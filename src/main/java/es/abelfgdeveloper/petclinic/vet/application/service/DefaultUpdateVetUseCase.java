package es.abelfgdeveloper.petclinic.vet.application.service;

import es.abelfgdeveloper.core.exception.domain.ValidationException;
import es.abelfgdeveloper.petclinic.vet.application.port.in.update.UpdateVetCommand;
import es.abelfgdeveloper.petclinic.vet.application.port.in.update.UpdateVetUseCase;
import es.abelfgdeveloper.petclinic.vet.application.port.out.VetRepository;
import es.abelfgdeveloper.petclinic.vet.domain.exception.VetErrorCode;
import es.abelfgdeveloper.petclinic.vet.domain.exception.VetNotFoundException;
import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;
import es.abelfgdeveloper.petclinic.vet.domain.service.VetFieldValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultUpdateVetUseCase implements UpdateVetUseCase {

  private final VetRepository vetRepository;
  private final VetFieldValidatorService vetFieldValidatorService;

  @Override
  public Vet execute(UpdateVetCommand command) {
    validateCommand(command);

    Vet vet = findVet(command.getId());
    vet.setFirstName(command.getFirstName().trim());
    vet.setLastName(command.getLastName().trim());

    return vetRepository.update(vet);
  }

  private void validateCommand(UpdateVetCommand command) {
    if (command == null) {
      throw new ValidationException(VetErrorCode.BODY_NULL);
    }
    vetFieldValidatorService.validateFirstName(command.getFirstName());
    vetFieldValidatorService.validateLastName(command.getLastName());
  }

  private Vet findVet(String id) {
    return vetRepository.findById(id).orElseThrow(VetNotFoundException::new);
  }
}
