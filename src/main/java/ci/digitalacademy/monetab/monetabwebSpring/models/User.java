package ci.digitalacademy.monetab.monetabwebSpring.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pseudo",unique = true,nullable = false)
    private String identifiant;
    @Column(name = "password",unique = true,nullable = false)
    private String motDePasse;


    @Column(name = "date_de_creation",nullable = false)
    private Instant dateCreation;
    @OneToOne
    private Adress adress;
}
