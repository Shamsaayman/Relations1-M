package org.example.relationsex1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should be not empty")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String name;
    @ManyToOne
    @JoinColumn(name = "teacher id", referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;
}
