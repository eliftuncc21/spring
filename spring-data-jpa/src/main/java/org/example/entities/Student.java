package org.example.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "student")
@Data //Getter setter birleşimi
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name ="last_name", nullable = false)
    private String lastName;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "birth_of_date", nullable = true)
    private Date birth_of_date;

}
