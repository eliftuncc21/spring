package org.example.services.impl;

import org.example.dto.customer.DtoCustomer;
import org.example.dto.customer.DtoCustomerIU;
import org.example.entities.Customer;
import org.example.entities.Address;
import org.example.repository.CustomerRepository;
import org.example.repository.AddressRepository;
import org.example.services.ICustomerServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServicesImpl implements ICustomerServices {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {

        Address address = addressRepository.findById(dtoCustomerIU.getAddressId())
                .orElse(null);

        Customer customer = new Customer();
        customer.setName(dtoCustomerIU.getName());
        customer.setAddress(address);

        Customer savedCustomer = customerRepository.save(customer);

        DtoCustomer dtoCustomer = new DtoCustomer();
        dtoCustomer.setName(savedCustomer.getName());
        dtoCustomer.setAddressId(savedCustomer.getAddress().getAddressId());
        return dtoCustomer;
    }

    public List<DtoCustomer> getCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<DtoCustomer> dtoCustomerList = new ArrayList<>();
        for (Customer customer : customerList){
            DtoCustomer dtoCustomer = new DtoCustomer();
            dtoCustomer.setName(customer.getName());
            dtoCustomer.setAddressId(customer.getAddress().getAddressId());
            dtoCustomerList.add(dtoCustomer);
        }
        return dtoCustomerList;
    }

    @Override
    public DtoCustomer findCustomerById(Integer id){
        Optional<Customer> optional = customerRepository.findById(id);

        if(optional.isPresent()){
            DtoCustomer dtoCustomer = new DtoCustomer();
            dtoCustomer.setName(optional.get().getName());
            dtoCustomer.setAddressId(optional.get().getAddress().getAddressId());
            return dtoCustomer;
        }
        return null;
    }
}