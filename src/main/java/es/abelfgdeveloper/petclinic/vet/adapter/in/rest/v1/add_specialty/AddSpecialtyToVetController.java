package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.add_specialty;

import es.abelfgdeveloper.petclinic.vet.application.port.in.add_specialty.AddSpecialtyToVetCommand;
import es.abelfgdeveloper.petclinic.vet.application.port.in.add_specialty.AddSpecialtyToVetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AddSpecialtyToVetController {

  private final AddSpecialtyToVetUseCase useCase;

  @PutMapping("/v1/vets/{vetId}/specialties/{specialtyId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void execute(
      @PathVariable("vetId") String vetId, @PathVariable("specialtyId") String specialtyId) {
    useCase.execute(mapRequest(vetId, specialtyId));
  }

  private AddSpecialtyToVetCommand mapRequest(String vetId, String specialtyId) {
    return AddSpecialtyToVetCommand.builder().vetId(vetId).specialtyId(specialtyId).build();
  }
}
