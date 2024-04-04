package org.example.relationsex1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should be not empty")
    @Column(columnDefinition = "varchar(5) not null")
    private String name;
    @Email
    @NotEmpty(message = "email should be not empty")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String email ;
    @NotNull(message = "age should be not empty")
    @Column(columnDefinition = "int not null ")
    private Integer age;
    @NotNull(message = "salary should be not empty")
    @Column(columnDefinition = "int not null ")
    private Integer salary;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course>courses;
}
