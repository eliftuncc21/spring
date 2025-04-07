package org.example.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.controller.IAddressController;
import org.example.dto.address.AddressRequestDto;
import org.example.dto.address.AddressResponseDto;
import org.example.services.IAddressServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest/api/address")
@RequiredArgsConstructor
public class AddressControllerImpl implements IAddressController {

    private final IAddressServices addressServices;

    @PostMapping(path = "/save")
    @Override
    public AddressResponseDto saveAddress(@RequestBody @Valid AddressRequestDto addressRequestDto) {
        return addressServices.saveAddress(addressRequestDto);
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public AddressResponseDto findAddressById(@RequestParam(name = "id") Integer id) {
        return addressServices.findAddressById(id);
    }
}
