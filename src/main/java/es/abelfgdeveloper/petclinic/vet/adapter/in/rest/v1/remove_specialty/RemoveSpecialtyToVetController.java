package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.remove_specialty;

import es.abelfgdeveloper.petclinic.vet.application.port.in.remove_specialty.RemoveSpecialtyToVetCommand;
import es.abelfgdeveloper.petclinic.vet.application.port.in.remove_specialty.RemoveSpecialtyToVetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RemoveSpecialtyToVetController {

  private final RemoveSpecialtyToVetUseCase useCase;

  @DeleteMapping("/v1/vets/{vetId}/specialties/{specialtyId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void execute(
      @PathVariable("vetId") String vetId, @PathVariable("specialtyId") String specialtyId) {
    useCase.execute(mapRequest(vetId, specialtyId));
  }

  private RemoveSpecialtyToVetCommand mapRequest(String vetId, String specialtyId) {
    return RemoveSpecialtyToVetCommand.builder().vetId(vetId).specialtyId(specialtyId).build();
  }
}
