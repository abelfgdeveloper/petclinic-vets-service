package es.abelfgdeveloper.petclinic.specialty.application.service;

import es.abelfgdeveloper.petclinic.specialty.application.port.in.find.FindSpecialtyUseCase;
import es.abelfgdeveloper.petclinic.specialty.application.port.out.SpecialtyRepository;
import es.abelfgdeveloper.petclinic.specialty.domain.exception.SpecialtyNotFoundException;
import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultFindSpecialtyUseCase implements FindSpecialtyUseCase {

  private final SpecialtyRepository specialtyRepository;

  @Override
  public Specialty execute(String id) {
    return specialtyRepository.findById(id).orElseThrow(SpecialtyNotFoundException::new);
  }
}
