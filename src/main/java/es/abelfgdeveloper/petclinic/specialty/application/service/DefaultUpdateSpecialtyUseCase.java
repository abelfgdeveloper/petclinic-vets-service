package es.abelfgdeveloper.petclinic.specialty.application.service;

import es.abelfgdeveloper.core.exception.domain.ValidationException;
import es.abelfgdeveloper.petclinic.specialty.application.port.in.update.UpdateSpecialtyCommand;
import es.abelfgdeveloper.petclinic.specialty.application.port.in.update.UpdateSpecialtyUseCase;
import es.abelfgdeveloper.petclinic.specialty.application.port.out.SpecialtyRepository;
import es.abelfgdeveloper.petclinic.specialty.domain.exception.SpecialtyErrorCode;
import es.abelfgdeveloper.petclinic.specialty.domain.exception.SpecialtyNotFoundException;
import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;
import es.abelfgdeveloper.petclinic.specialty.domain.service.SpecialtyFieldValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultUpdateSpecialtyUseCase implements UpdateSpecialtyUseCase {

  private final SpecialtyRepository specialtyRepository;
  private final SpecialtyFieldValidatorService specialtyFieldValidator;

  @Override
  public Specialty execute(UpdateSpecialtyCommand command) {
    validateCommand(command);
    Specialty specialtySaved = findSpecialty(command.getId());

    specialtySaved.setName(command.getName());

    return specialtyRepository.update(specialtySaved);
  }

  private void validateCommand(UpdateSpecialtyCommand command) {
    if (command == null) {
      throw new ValidationException(SpecialtyErrorCode.BODY_NULL);
    }
    specialtyFieldValidator.validateId(command.getId());
    specialtyFieldValidator.validateName(command.getName());
  }

  private Specialty findSpecialty(String id) {
    return specialtyRepository.findById(id).orElseThrow(SpecialtyNotFoundException::new);
  }
}
