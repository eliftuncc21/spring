package org.example.controller;

import org.example.dto.customer.DtoCustomer;
import org.example.dto.customer.DtoCustomerIU;

import java.util.List;

public interface ICustomerController {
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
    public List<DtoCustomer> getCustomers();
    public DtoCustomer getCustomerById(Integer id);
}
