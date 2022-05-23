package es.abelfgdeveloper.petclinic.specialty.application.service;

import es.abelfgdeveloper.core.exception.domain.ValidationException;
import es.abelfgdeveloper.petclinic.specialty.application.port.in.create.CreateSpecialtyCommand;
import es.abelfgdeveloper.petclinic.specialty.application.port.in.create.CreateSpecialtyUseCase;
import es.abelfgdeveloper.petclinic.specialty.application.port.out.SpecialtyRepository;
import es.abelfgdeveloper.petclinic.specialty.domain.exception.SpecialtyErrorCode;
import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;
import es.abelfgdeveloper.petclinic.specialty.domain.service.SpecialtyFieldValidatorService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultCreateSpecialtyUseCase implements CreateSpecialtyUseCase {

  private final SpecialtyRepository specialtyRepository;
  private final SpecialtyFieldValidatorService specialtyFieldValidator;

  @Override
  public Specialty execute(CreateSpecialtyCommand command) {
    validateCommand(command);

    Specialty specialtyToSave =
        Specialty.builder().id(UUID.randomUUID().toString()).name(command.getName()).build();

    return specialtyRepository.create(specialtyToSave);
  }

  private void validateCommand(CreateSpecialtyCommand command) {
    if (command == null) {
      throw new ValidationException(SpecialtyErrorCode.BODY_NULL);
    }
    specialtyFieldValidator.validateName(command.getName());
  }
}
