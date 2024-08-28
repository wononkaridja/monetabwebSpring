package ci.digitalacademy.monetab.monetabwebSpring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false)
    private String nom;

    @Column(name = "last_name",nullable = false)
    private String prenom;
    @Column(unique = true,nullable = false)
    private String mail;
    private String genre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    @OneToOne
    @JoinColumn(name = "adress_id")
    private Adress adress;
}
