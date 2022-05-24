package es.abelfgdeveloper.petclinic.vet.application.service;

import es.abelfgdeveloper.core.exception.domain.ValidationException;
import es.abelfgdeveloper.petclinic.vet.application.port.in.create.CreateVetCommand;
import es.abelfgdeveloper.petclinic.vet.application.port.in.create.CreateVetUseCase;
import es.abelfgdeveloper.petclinic.vet.application.port.out.VetRepository;
import es.abelfgdeveloper.petclinic.vet.domain.exception.VetErrorCode;
import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;
import es.abelfgdeveloper.petclinic.vet.domain.service.VetFieldValidatorService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultCreateVetUseCase implements CreateVetUseCase {

  private final VetRepository vetRepository;
  private final VetFieldValidatorService vetFieldValidatorService;

  @Override
  public Vet execute(CreateVetCommand command) {
    validateCommand(command);

    Vet vetToSave =
        Vet.builder()
            .id(UUID.randomUUID().toString())
            .firstName(command.getFirstName())
            .lastName(command.getLastName())
            .build();

    return vetRepository.create(vetToSave);
  }

  private void validateCommand(CreateVetCommand command) {
    if (command == null) {
      throw new ValidationException(VetErrorCode.BODY_NULL);
    }
    vetFieldValidatorService.validateFirstName(command.getFirstName());
    vetFieldValidatorService.validateLastName(command.getLastName());
  }
}
