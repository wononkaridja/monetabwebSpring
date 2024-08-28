package ci.digitalacademy.monetab.monetabwebSpring.service.mapper;

import ci.digitalacademy.monetab.monetabwebSpring.models.Adress;
import ci.digitalacademy.monetab.monetabwebSpring.service.dto.AdressDTO;
import lombok.Getter;
import lombok.Setter;


public class AdressMapper {
    private AdressMapper() {}

    public static AdressDTO toDTO(Adress adress){
        AdressDTO adressDTO = new AdressDTO();
        adressDTO.setId(adress .getId());
        adressDTO.setCity(adress.getCity());
        adressDTO.setStreet(adress.getStreet());
        adressDTO.setCountry(adress.getCountry());

        return adressDTO;
    }

    public static Adress toEntity(AdressDTO adressDTO){
        Adress adress = new Adress();
        adress.setId(adressDTO.getId());
        adress.setCity(adressDTO.getCity());
        adress.setStreet(adressDTO.getStreet());
        adress.setCountry(adressDTO.getCountry());

        return adress;
    }
}

