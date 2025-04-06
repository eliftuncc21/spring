package org.example.services;

import org.example.dto.address.DtoAddress;
import org.example.dto.address.DtoAddressIU;

public interface IAddressServices {
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
    public DtoAddress findAddressById(Integer addressId);
}
