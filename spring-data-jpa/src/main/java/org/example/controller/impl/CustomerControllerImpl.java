package org.example.controller.impl;

import jakarta.validation.Valid;
import org.example.controller.ICustomerController;
import org.example.dto.customer.DtoCustomer;
import org.example.dto.customer.DtoCustomerIU;
import org.example.services.ICustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {

    @Autowired
    private ICustomerServices customerServices;

    @PostMapping(path = "/save")
    @Override
    public DtoCustomer saveCustomer(@RequestBody @Valid DtoCustomerIU dtoCustomerIU) {
        return customerServices.saveCustomer(dtoCustomerIU);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoCustomer> getCustomers() {
        return customerServices.getCustomers();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoCustomer getCustomerById(@PathVariable(name = "id", required = true) Integer id) {
        return customerServices.findCustomerById(id);
    }
}
