package org.example.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.customer.CustomerResponseDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDto {
    private Integer addressId;
    private String description;
    private CustomerResponseDto customer;
}
