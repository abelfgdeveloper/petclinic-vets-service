package es.abelfgdeveloper.petclinic.vet.application.port.in.create;

import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;

public interface CreateVetUseCase {

  Vet execute(CreateVetCommand command);
}
