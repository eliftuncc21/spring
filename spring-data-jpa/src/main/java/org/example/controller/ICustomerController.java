package org.example.controller;

import org.example.dto.customer.CustomerRequestDto;
import org.example.dto.customer.CustomerResponseDto;

import java.util.List;

public interface ICustomerController {
    CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getCustomers();
    CustomerResponseDto getCustomerById(Integer id);
}
