package org.example.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.student.DtoStudent;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCourse {
    private Integer id;
    private String name;
}