package ci.digitalacademy.monetab.monetabwebSpring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student extends Person {

    @Column(nullable = false)
    private String matricule;
    private String classe;
}
