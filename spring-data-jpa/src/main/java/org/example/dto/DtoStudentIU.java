package org.example.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
    @NotEmpty(message = "firstName alanı boş bırakılamaz")
    @Min(value = 3)
    @Max(value = 10)
    private String firstName;
    @Size(min = 3, max = 10, message = "lastName alanı 3 karakterden az ve 10 karakterden fazla olamaz")
    private String lastName;
    @NotNull(message = "birth_of_date alanı boş bırakılamaz")
    private Date birth_of_date;
}
