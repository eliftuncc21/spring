package org.example.controller.impl;

import jakarta.validation.Valid;
import org.example.controller.IAddressController;
import org.example.dto.address.DtoAddress;
import org.example.dto.address.DtoAddressIU;
import org.example.services.IAddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest/api/address")
public class AddressControllerImpl implements IAddressController {

    @Autowired
    private IAddressServices addressServices;

    @PostMapping(path = "/save")
    @Override
    public DtoAddress saveAddress(@RequestBody @Valid DtoAddressIU dtoAddressIU) {
        return addressServices.saveAddress(dtoAddressIU);
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoAddress findAddressById(@PathVariable(name = "id", required = true) Integer id) {
        return addressServices.findAddressById(id);
    }
}
