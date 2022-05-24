package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.create;

import es.abelfgdeveloper.petclinic.vet.application.port.in.create.CreateVetCommand;
import es.abelfgdeveloper.petclinic.vet.application.port.in.create.CreateVetUseCase;
import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CreateVetController {

  private final CreateVetUseCase useCase;

  @PostMapping("/v1/vets")
  @ResponseStatus(HttpStatus.CREATED)
  public CreateVetResponseResource execute(@RequestBody CreateVetRequestResource request) {
    return mapResponse(useCase.execute(mapRequest(request)));
  }

  private CreateVetCommand mapRequest(CreateVetRequestResource request) {
    return new CreateVetCommand(request.getFirstName(), request.getLastName());
  }

  private CreateVetResponseResource mapResponse(Vet vet) {
    return CreateVetResponseResource.builder().id(vet.getId()).build();
  }
}
