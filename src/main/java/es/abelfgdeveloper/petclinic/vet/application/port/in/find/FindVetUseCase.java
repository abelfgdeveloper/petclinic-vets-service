package es.abelfgdeveloper.petclinic.vet.application.port.in.find;

import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;

public interface FindVetUseCase {

  Vet execute(String id);
}
