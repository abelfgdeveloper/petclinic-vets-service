package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.delete;

import es.abelfgdeveloper.petclinic.vet.application.port.in.delete.DeleteVetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DeleteVetController {

  private final DeleteVetUseCase useCase;

  @DeleteMapping("/v1/vets/{vetId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void execute(@PathVariable("vetId") String vetId) {
    useCase.execute(vetId);
  }
}
