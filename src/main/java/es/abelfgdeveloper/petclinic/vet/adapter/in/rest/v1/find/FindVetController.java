package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.find;

import es.abelfgdeveloper.petclinic.vet.application.port.in.find.FindVetUseCase;
import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FindVetController {

  private final FindVetUseCase useCase;

  @GetMapping("/v1/vets/{vetId}")
  public FindVetResponseResource execute(@PathVariable("vetId") String vetId) {
    return mapResponse(useCase.execute(vetId));
  }

  private FindVetResponseResource mapResponse(Vet vet) {
    return FindVetResponseResource.builder()
        .id(vet.getId())
        .firstName(vet.getFirstName())
        .lastName(vet.getLastName())
        .specialties(vet.getSpecialties())
        .build();
  }
}
