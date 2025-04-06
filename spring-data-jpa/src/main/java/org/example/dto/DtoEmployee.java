package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.department.DtoDepartment;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployee {
    private Integer id;
    private String name;
    private DtoDepartment department;
}
