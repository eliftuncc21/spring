package org.example.services;

import org.example.dto.address.AddressRequestDto;
import org.example.dto.address.AddressResponseDto;

public interface IAddressServices {
    AddressResponseDto saveAddress(AddressRequestDto addressRequestDto);
    AddressResponseDto findAddressById(Integer addressId);
}
