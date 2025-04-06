package org.example.dto.customer;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCustomerIU {
    @NotEmpty(message = "Name alanı boş bırakılamaz")
    @Size(min = 3, max = 10, message = "Name alanı 3 ile 10 karakter arasında olmalı")
    private String name;
    @NotNull(message = "address alanı boş bırakılamaz")
    private Integer addressId;
}