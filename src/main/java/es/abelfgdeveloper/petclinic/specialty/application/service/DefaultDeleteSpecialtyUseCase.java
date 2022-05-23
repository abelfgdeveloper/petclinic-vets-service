package es.abelfgdeveloper.petclinic.specialty.application.service;

import es.abelfgdeveloper.petclinic.specialty.application.port.in.delete.DeleteSpecialtyUseCase;
import es.abelfgdeveloper.petclinic.specialty.application.port.out.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultDeleteSpecialtyUseCase implements DeleteSpecialtyUseCase {

  private final SpecialtyRepository specialtyRepository;

  @Override
  public void execute(String id) {
    specialtyRepository.deleteById(id);
  }
}
