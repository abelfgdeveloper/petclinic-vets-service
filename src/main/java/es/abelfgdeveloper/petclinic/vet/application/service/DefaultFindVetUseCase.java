package es.abelfgdeveloper.petclinic.vet.application.service;

import es.abelfgdeveloper.petclinic.vet.application.port.in.find.FindVetUseCase;
import es.abelfgdeveloper.petclinic.vet.application.port.out.VetRepository;
import es.abelfgdeveloper.petclinic.vet.domain.exception.VetNotFoundException;
import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultFindVetUseCase implements FindVetUseCase {

  private final VetRepository vetRepository;

  @Override
  public Vet execute(String id) {
    return vetRepository.findById(id).orElseThrow(VetNotFoundException::new);
  }
}
