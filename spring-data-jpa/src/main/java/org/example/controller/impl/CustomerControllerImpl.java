package org.example.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.controller.ICustomerController;
import org.example.dto.customer.CustomerRequestDto;
import org.example.dto.customer.CustomerResponseDto;
import org.example.services.ICustomerServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api/customer")
@RequiredArgsConstructor
public class CustomerControllerImpl implements ICustomerController {

    private final ICustomerServices customerServices;

    @PostMapping(path = "/save")
    @Override
    public CustomerResponseDto saveCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        return customerServices.saveCustomer(customerRequestDto);
    }

    @GetMapping(path = "/list")
    @Override
    public List<CustomerResponseDto> getCustomers() {
        return customerServices.getCustomers();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public CustomerResponseDto getCustomerById(@PathVariable(name = "id", required = true) Integer id) {
        return customerServices.findCustomerById(id);
    }
}
