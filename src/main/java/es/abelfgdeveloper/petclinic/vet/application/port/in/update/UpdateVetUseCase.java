package es.abelfgdeveloper.petclinic.vet.application.port.in.update;

import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;

public interface UpdateVetUseCase {

  Vet execute(UpdateVetCommand command);
}
