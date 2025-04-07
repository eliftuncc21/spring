package org.example.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.address.AddressRequestDto;
import org.example.dto.address.AddressResponseDto;
import org.example.dto.customer.CustomerResponseDto;
import org.example.entities.Address;
import org.example.repository.AddressRepository;
import org.example.services.IAddressServices;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServicesImpl implements IAddressServices {

    private final AddressRepository addressRepository;

    @Override
    public AddressResponseDto saveAddress(AddressRequestDto addressRequestDto) {
        AddressResponseDto dtoAddress = new AddressResponseDto();
        Address address = new Address();
        BeanUtils.copyProperties(addressRequestDto, address);
        Address dbAddress = addressRepository.save(address);
        BeanUtils.copyProperties(dbAddress, dtoAddress);
        return dtoAddress;
    }

    @Override
    public AddressResponseDto findAddressById(Integer addressId) {
        AddressResponseDto dtoAddress = new AddressResponseDto();
        Optional<Address> optional = addressRepository.findById(addressId);
        if(optional.isEmpty()){
            return null;
        }
        Address address = optional.get();
        BeanUtils.copyProperties(address, dtoAddress);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setName(address.getCustomer().getName());
        customerResponseDto.setAddressId(addressId);

        dtoAddress.setCustomer(customerResponseDto);
        return dtoAddress;
    }
}
