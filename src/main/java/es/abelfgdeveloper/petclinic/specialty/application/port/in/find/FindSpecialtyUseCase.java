package es.abelfgdeveloper.petclinic.specialty.application.port.in.find;

import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;

public interface FindSpecialtyUseCase {

  Specialty execute(String id);
}
