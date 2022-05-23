package es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.delete;

import es.abelfgdeveloper.petclinic.specialty.application.port.in.delete.DeleteSpecialtyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DeleteSpecialtyController {

  private final DeleteSpecialtyUseCase useCase;

  @DeleteMapping("/v1/specialties/{specialtyId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void execute(@PathVariable("specialtyId") String specialtyId) {
    useCase.execute(specialtyId);
  }
}
