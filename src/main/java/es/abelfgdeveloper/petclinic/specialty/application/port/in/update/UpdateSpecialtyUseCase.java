package es.abelfgdeveloper.petclinic.specialty.application.port.in.update;

import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;

public interface UpdateSpecialtyUseCase {

  Specialty execute(UpdateSpecialtyCommand command);
}
