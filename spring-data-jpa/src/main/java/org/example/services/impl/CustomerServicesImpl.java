package org.example.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.customer.CustomerRequestDto;
import org.example.dto.customer.CustomerResponseDto;
import org.example.entities.Customer;
import org.example.entities.Address;
import org.example.repository.CustomerRepository;
import org.example.repository.AddressRepository;
import org.example.services.ICustomerServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServicesImpl implements ICustomerServices {

    private final CustomerRepository customerRepository;

    private final AddressRepository addressRepository;

    @Override
    public CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto) {

        Address address = addressRepository.findById(customerRequestDto.getAddressId())
                .orElse(null);

        Customer customer = new Customer();
        customer.setName(customerRequestDto.getName());
        customer.setAddress(address);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setName(savedCustomer.getName());
        customerResponseDto.setAddressId(savedCustomer.getAddress().getAddressId());
        return customerResponseDto;
    }

    public List<CustomerResponseDto> getCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerResponseDto customerResponseDto = new CustomerResponseDto();
            customerResponseDto.setName(customer.getName());
            customerResponseDto.setAddressId(customer.getAddress().getAddressId());
            customerResponseDtoList.add(customerResponseDto);
        }
        return customerResponseDtoList;
    }

    @Override
    public CustomerResponseDto findCustomerById(Integer id){
        Optional<Customer> optional = customerRepository.findById(id);

        if(optional.isPresent()){
            CustomerResponseDto customerResponseDto = new CustomerResponseDto();
            customerResponseDto.setName(optional.get().getName());
            customerResponseDto.setAddressId(optional.get().getAddress().getAddressId());
            return customerResponseDto;
        }
        return null;
    }
}