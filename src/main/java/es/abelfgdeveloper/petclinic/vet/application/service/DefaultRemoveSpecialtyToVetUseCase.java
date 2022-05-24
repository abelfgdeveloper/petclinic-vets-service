package es.abelfgdeveloper.petclinic.vet.application.service;

import es.abelfgdeveloper.core.exception.domain.ValidationException;
import es.abelfgdeveloper.petclinic.specialty.application.port.out.SpecialtyRepository;
import es.abelfgdeveloper.petclinic.specialty.domain.exception.SpecialtyNotFoundException;
import es.abelfgdeveloper.petclinic.vet.application.port.in.remove_specialty.RemoveSpecialtyToVetCommand;
import es.abelfgdeveloper.petclinic.vet.application.port.in.remove_specialty.RemoveSpecialtyToVetUseCase;
import es.abelfgdeveloper.petclinic.vet.application.port.out.VetRepository;
import es.abelfgdeveloper.petclinic.vet.domain.exception.VetErrorCode;
import es.abelfgdeveloper.petclinic.vet.domain.exception.VetNotFoundException;
import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultRemoveSpecialtyToVetUseCase implements RemoveSpecialtyToVetUseCase {

  private final VetRepository vetRepository;
  private final SpecialtyRepository specialtyRepository;

  @Override
  public void execute(RemoveSpecialtyToVetCommand command) {
    Vet vet = findVet(command.getVetId());
    validateSpecialtyExist(command.getSpecialtyId());
    validateHasSpecialty(vet, command.getSpecialtyId());
    vet.getSpecialties().remove(command.getSpecialtyId());
    vetRepository.update(vet);
  }

  private Vet findVet(String id) {
    return vetRepository.findById(id).orElseThrow(VetNotFoundException::new);
  }

  private void validateSpecialtyExist(String id) {
    specialtyRepository.findById(id).orElseThrow(SpecialtyNotFoundException::new);
  }

  private void validateHasSpecialty(Vet vet, String specialtyId) {
    if (!vet.getSpecialties().contains(specialtyId)) {
      throw new ValidationException(VetErrorCode.NOT_HAVE_SPECIALTY);
    }
  }
}
