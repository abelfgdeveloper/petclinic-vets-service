package es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence;

import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;
import org.springframework.stereotype.Component;

@Component
public class SpecialtyMapper {

  public Specialty map(SpecialtyEntity specialty) {
    return Specialty.builder().id(specialty.getId()).name(specialty.getName()).build();
  }
}
