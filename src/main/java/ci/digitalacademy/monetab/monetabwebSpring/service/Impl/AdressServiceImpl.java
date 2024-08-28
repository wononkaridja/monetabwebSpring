package ci.digitalacademy.monetab.monetabwebSpring.service.Impl;


import ci.digitalacademy.monetab.monetabwebSpring.models.Adress;
import ci.digitalacademy.monetab.monetabwebSpring.models.Teacher;
import ci.digitalacademy.monetab.monetabwebSpring.repositories.AdressRepository;
import ci.digitalacademy.monetab.monetabwebSpring.service.AdressService;
import ci.digitalacademy.monetab.monetabwebSpring.service.dto.AdressDTO;
import ci.digitalacademy.monetab.monetabwebSpring.service.mapper.AdressMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@RequiredArgsConstructor
public class AdressServiceImpl implements AdressService {
    private final AdressRepository adressRepository;

    @Override
    public AdressDTO save(AdressDTO adressDTO) {
        log.debug("Reguest to save: {}", adressDTO);
        Adress adress = AdressMapper.toEntity(adressDTO);
        adress = adressRepository.save(adress);

        return AdressMapper.toDTO(adress);
    }

    @Override
    public AdressDTO update(AdressDTO adressDTO) {
        return findOne(adressDTO.getId()).map(existingAdress -> {
             existingAdress.setCity(adressDTO.getCity());
             return save(existingAdress);
        }).orElseThrow(() -> new IllegalArgumentException());



 }

    @Override
    public Optional<AdressDTO> findOne(Long id) {

        return adressRepository.findById(id).map(adress -> {
        return AdressMapper.toDTO(adress);
        });
    }

    @Override
    public List<AdressDTO> findAll() {
        return adressRepository.findAll().stream().map(adress -> {
            return AdressMapper.toDTO(adress);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        if (!adressRepository.existsById(id)) {
            throw new EntityNotFoundException("Adress avec l'ID " + id + " non trouvé.");
        }
        // Supprime l'enseignant par ID
        adressRepository.deleteById(id);

    }
}
