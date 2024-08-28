package ci.digitalacademy.monetab.monetabwebSpring.service;


import ci.digitalacademy.monetab.monetabwebSpring.models.Adress;
import ci.digitalacademy.monetab.monetabwebSpring.service.dto.AdressDTO;

import java.util.List;
import java.util.Optional;

public interface AdressService {
    AdressDTO save(AdressDTO adress);
    AdressDTO update (AdressDTO adress);
    Optional<AdressDTO> findOne(Long id);
    List<AdressDTO> findAll();
    void delete (Long id);
}
