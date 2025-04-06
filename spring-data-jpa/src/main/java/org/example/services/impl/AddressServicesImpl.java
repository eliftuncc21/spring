package org.example.services.impl;

import org.example.dto.address.DtoAddress;
import org.example.dto.address.DtoAddressIU;
import org.example.dto.customer.DtoCustomer;
import org.example.entities.Address;
import org.example.repository.AddressRepository;
import org.example.services.IAddressServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServicesImpl implements IAddressServices {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        DtoAddress dtoAddress = new DtoAddress();
        Address address = new Address();
        BeanUtils.copyProperties(dtoAddressIU, address);
        Address dbAddress = addressRepository.save(address);
        BeanUtils.copyProperties(dbAddress, dtoAddress);
        return dtoAddress;
    }

    @Override
    public DtoAddress findAddressById(Integer addressId) {
        DtoAddress dtoAddress = new DtoAddress();
        Optional<Address> optional = addressRepository.findById(addressId);
        if(optional.isEmpty()){
            return null;
        }
        Address address = optional.get();
        BeanUtils.copyProperties(address, dtoAddress);

        DtoCustomer dtoCustomer = new DtoCustomer();
        dtoCustomer.setName(address.getCustomer().getName());
        dtoCustomer.setAddressId(addressId);

        dtoAddress.setCustomer(dtoCustomer);
        return dtoAddress;
    }
}
