package com.ecommerce.project.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="addresses")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5, message = "String name must contains at least 5 characters")
    private String street;

    @NotBlank
    @Size(min = 5, message = "Building name must contains at least 5 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 4, message = "City name must contains at least 4 characters")
    private String city;

    @NotBlank
    @Size(min = 2, message = "State name must contains at least 2 characters")
    private String State;

    @NotBlank
    @Size(min = 2, message = "Country name must contains at least 2 characters")
    private String Country;

    @NotBlank
    @Size(min = 5, message = "Pincode must contains at least 5 characters")
    private String pincode;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address(String street, String buildingName, String city, String state, String country, String pincode, List<User> users) {
        this.street = street;
        this.buildingName = buildingName;
        this.city = city;
        State = state;
        Country = country;
        this.pincode = pincode;
        this.user = user;
    }

}
