package ci.digitalacademy.monetab.monetabwebSpring.service.dto;

import ci.digitalacademy.monetab.monetabwebSpring.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdressDTO {

    private Long id;


    private String country;

    private String city;


    private String street;



    private User user;
}
