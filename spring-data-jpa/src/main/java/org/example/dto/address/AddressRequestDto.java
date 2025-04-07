package org.example.dto.address;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDto {
    @Size(min = 3, max = 10, message = "Description alanı 3 karakterden az ve 10 karakterden fazla olamaz")
    private String description;
}
