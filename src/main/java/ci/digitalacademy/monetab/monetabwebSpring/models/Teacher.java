package ci.digitalacademy.monetab.monetabwebSpring.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.sql.results.graph.Fetch;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")

public class Teacher extends Person {


    @Column(nullable = false, name = "vacant")
    private Boolean vacant;

    @Column(nullable = false, name = "matiereEnseigne")
    private String matiereEnseigne;


    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher")
    //private Set<FicheNote> noteFiles;



}
