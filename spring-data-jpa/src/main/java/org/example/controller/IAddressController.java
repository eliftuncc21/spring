package org.example.controller;

import org.example.dto.address.DtoAddress;
import org.example.dto.address.DtoAddressIU;

public interface IAddressController {
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
    public DtoAddress findAddressById(Integer id);
}
