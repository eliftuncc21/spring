package org.example.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.customer.DtoCustomer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoAddress {
    private Integer addressId;
    private String description;
    private DtoCustomer customer;
}
