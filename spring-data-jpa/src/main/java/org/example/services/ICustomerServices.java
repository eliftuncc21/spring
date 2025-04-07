package org.example.services;

import org.example.dto.customer.CustomerResponseDto;
import org.example.dto.customer.CustomerRequestDto;

import java.util.List;

public interface ICustomerServices {
    CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getCustomers();
    CustomerResponseDto findCustomerById(Integer id);
}
