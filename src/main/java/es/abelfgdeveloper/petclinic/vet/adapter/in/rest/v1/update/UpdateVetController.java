package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.update;

import es.abelfgdeveloper.petclinic.vet.application.port.in.update.UpdateVetCommand;
import es.abelfgdeveloper.petclinic.vet.application.port.in.update.UpdateVetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UpdateVetController {

  private final UpdateVetUseCase useCase;

  @PutMapping("/v1/vets/{vetId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void execute(
      @PathVariable("vetId") String vetId, @RequestBody UpdateVetRequestResource request) {
    useCase.execute(mapRequest(vetId, request));
  }

  private UpdateVetCommand mapRequest(String specialtyId, UpdateVetRequestResource request) {
    return UpdateVetCommand.builder()
        .id(specialtyId)
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .build();
  }
}
