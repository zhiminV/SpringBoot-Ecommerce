package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {

    private Long addressId;
    private Long paymentId;
    private String paymentMethod;
    private String pgStatus;
    private String pgName;
    private String pgResponseMessage;
}
