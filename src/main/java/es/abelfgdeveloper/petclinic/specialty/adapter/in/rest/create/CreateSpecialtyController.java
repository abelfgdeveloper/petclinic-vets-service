package es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.create;

import es.abelfgdeveloper.petclinic.specialty.application.port.in.create.CreateSpecialtyCommand;
import es.abelfgdeveloper.petclinic.specialty.application.port.in.create.CreateSpecialtyUseCase;
import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CreateSpecialtyController {

  private final CreateSpecialtyUseCase useCase;

  @PostMapping("/v1/specialties")
  @ResponseStatus(HttpStatus.CREATED)
  public CreateSpecialtyResponseResource execute(
      @RequestBody CreateSpecialtyRequestResource request) {
    return mapResponse(useCase.execute(mapRequest(request)));
  }

  private CreateSpecialtyCommand mapRequest(CreateSpecialtyRequestResource request) {
    return new CreateSpecialtyCommand(request.getName());
  }

  private CreateSpecialtyResponseResource mapResponse(Specialty specialty) {
    return CreateSpecialtyResponseResource.builder().id(specialty.getId()).build();
  }
}
