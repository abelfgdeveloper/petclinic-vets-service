package es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.find;

import es.abelfgdeveloper.petclinic.specialty.application.port.in.find.FindSpecialtyUseCase;
import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FindSpecialtyController {

  private final FindSpecialtyUseCase useCase;

  @GetMapping("/v1/specialties/{specialtyId}")
  public FindSpecialtyResponseResource execute(@PathVariable("specialtyId") String specialtyId) {
    return mapResponse(useCase.execute(specialtyId));
  }

  private FindSpecialtyResponseResource mapResponse(Specialty specialty) {
    return FindSpecialtyResponseResource.builder()
        .id(specialty.getId())
        .name(specialty.getName())
        .build();
  }
}
