package org.example.services;

import org.example.dto.customer.DtoCustomer;
import org.example.dto.customer.DtoCustomerIU;

import java.util.List;

public interface ICustomerServices {
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
    public List<DtoCustomer> getCustomers();
    public DtoCustomer findCustomerById(Integer id);
}
