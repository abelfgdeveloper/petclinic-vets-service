package es.abelfgdeveloper.petclinic.specialty.application.port.in.create;

import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;

public interface CreateSpecialtyUseCase {

  Specialty execute(CreateSpecialtyCommand command);
}
