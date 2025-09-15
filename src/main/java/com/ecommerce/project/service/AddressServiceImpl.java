package com.ecommerce.project.service;

import com.ecommerce.project.model.Address;
import com.ecommerce.project.model.User;
import com.ecommerce.project.payload.AddressDTO;
import com.ecommerce.project.repositories.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO, User user) {
        Address address = modelMapper.map(addressDTO,Address.class);
        address.setUser(user);
        List<Address> addressList = user.getAddresses();
        addressList.add(address);
        user.setAddresses(addressList);
        Address savedAddress = addressRepository.save(address);
        return modelMapper.map(savedAddress,AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getAddresses() {
        List<Address>  addresses = addressRepository.findAll();
        List<AddressDTO> addressDTOS = addresses.stream()
                .map(address->modelMapper.map(address,AddressDTO.class))
                .toList();
        return addressDTOS;
    }

    @Override
    public AddressDTO getAddressesById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()->new RuntimeException("Address not found"));
        return modelMapper.map(address,AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getUserAddresses(User user) {
        List<Address>  addresses = user.getAddresses();
        List<AddressDTO> addressDTOS = addresses.stream()
                .map(address->modelMapper.map(address,AddressDTO.class))
                .toList();
        return addressDTOS;
    }
}
