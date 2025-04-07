package org.example.controller;

import org.example.dto.address.AddressRequestDto;
import org.example.dto.address.AddressResponseDto;

public interface IAddressController {
    AddressResponseDto saveAddress(AddressRequestDto addressRequestDto);
    AddressResponseDto findAddressById(Integer id);
}
