package com.ecommerce.project.service;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements CategoryService {
//    private List<Category> categories = new ArrayList<>();

//    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new APIException("No Categories created till now");
        }
        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(category,CategoryDTO.class))
                .toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        return categoryResponse;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO CategoryDTO) {
//      category.setCategoryId(nextId++);
        // map the client's info to what we will store in the db
        Category category = modelMapper.map(CategoryDTO,Category.class);
        Category  categoryFromDb = categoryRepository.findByCategoryName(CategoryDTO.getCategoryName());
        if(categoryFromDb != null){
            throw new APIException("Category with name " + CategoryDTO.getCategoryName() + " already exists");
        }
        Category savedCategory = categoryRepository.save(category);
        // after save to db, we turn entity -> DTO for controller to use
        return modelMapper.map(savedCategory,CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory( Long categoryId) {
        //first find the category that need to delete
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId",categoryId));
        //delete entity in db
        categoryRepository.delete(category);
        CategoryDTO categoryDTO = modelMapper.map(category,CategoryDTO.class);
        return categoryDTO;

    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO CategoryDTO, Long categoryId) {

        //if not exit id then throw exception
        Category savedCategory  =  categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId",categoryId));;

        //if exit id then save it, but first need to make DTO->entity to save in db
        Category category = modelMapper.map(CategoryDTO,Category.class);
        category.setCategoryId(categoryId);
        // after save, we make entity->DTO for controller to use
        savedCategory =  categoryRepository.save(category);
        return modelMapper.map(savedCategory,CategoryDTO.class);
    }
}
