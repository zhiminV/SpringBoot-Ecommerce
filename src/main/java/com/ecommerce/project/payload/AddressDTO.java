package com.ecommerce.project.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long addressId;
    private String street;
    private String buildingName;
    private String city;
    private String State;
    private String Country;
    private String pincode;

}
