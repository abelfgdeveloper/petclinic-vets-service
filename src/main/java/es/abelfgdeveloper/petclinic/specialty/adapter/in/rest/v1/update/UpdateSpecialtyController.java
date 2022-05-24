package es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.v1.update;

import es.abelfgdeveloper.petclinic.specialty.application.port.in.update.UpdateSpecialtyCommand;
import es.abelfgdeveloper.petclinic.specialty.application.port.in.update.UpdateSpecialtyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UpdateSpecialtyController {

  private final UpdateSpecialtyUseCase useCase;

  @PutMapping("/v1/specialties/{specialtyId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void execute(
      @PathVariable("specialtyId") String specialtyId,
      @RequestBody UpdateSpecialtyRequestResource request) {
    useCase.execute(mapRequest(specialtyId, request));
  }

  private UpdateSpecialtyCommand mapRequest(
      String specialtyId, UpdateSpecialtyRequestResource request) {
    return UpdateSpecialtyCommand.builder().id(specialtyId).name(request.getName()).build();
  }
}
