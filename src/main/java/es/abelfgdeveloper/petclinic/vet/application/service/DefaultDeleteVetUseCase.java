package es.abelfgdeveloper.petclinic.vet.application.service;

import es.abelfgdeveloper.petclinic.vet.application.port.in.delete.DeleteVetUseCase;
import es.abelfgdeveloper.petclinic.vet.application.port.out.VetRepository;
import es.abelfgdeveloper.petclinic.vet.domain.exception.VetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultDeleteVetUseCase implements DeleteVetUseCase {

  private final VetRepository vetRepository;

  @Override
  public void execute(String id) {
    vetRepository.findById(id).orElseThrow(VetNotFoundException::new);
    vetRepository.deleteById(id);
  }
}
