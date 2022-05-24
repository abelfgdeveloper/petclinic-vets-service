package es.abelfgdeveloper.petclinic.vet.adapter.out.persistence;

import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;
import org.springframework.stereotype.Component;

@Component
public class VetMapper {

  public Vet map(VetEntity vet) {
    return Vet.builder()
        .id(vet.getId())
        .firstName(vet.getFirstName())
        .lastName(vet.getLastName())
        .specialties(vet.getSpecialties())
        .build();
  }
}
