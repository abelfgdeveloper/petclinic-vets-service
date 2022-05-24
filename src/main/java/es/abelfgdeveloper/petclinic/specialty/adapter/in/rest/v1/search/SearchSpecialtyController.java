package es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.v1.search;

import es.abelfgdeveloper.core.pagination.adapter.in.rest.PaginationMapper;
import es.abelfgdeveloper.core.pagination.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.specialty.application.port.in.search.SearchSpecialtyQuery;
import es.abelfgdeveloper.petclinic.specialty.application.port.in.search.SearchSpecialtyUseCase;
import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;
import es.abelfgdeveloper.petclinic.specialty.domain.model.SpecialtyPagination;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SearchSpecialtyController {

  private final SearchSpecialtyUseCase useCase;
  private final PaginationMapper paginationMapper;

  @GetMapping("/v1/specialties")
  public SearchSpecialtyResponseResource execute(
      @RequestParam(name = "page", required = false) Integer page,
      @RequestParam(name = "size", required = false) Integer size,
      @RequestParam(name = "name", required = false) String name) {
    return mapResponse(useCase.execute(mapRequest(page, size, name)));
  }

  private SearchSpecialtyQuery mapRequest(Integer page, Integer size, String name) {
    return SearchSpecialtyQuery.builder()
        .pagination(new PaginationIn(page, size))
        .name(name)
        .build();
  }

  public SearchSpecialtyResponseResource mapResponse(SpecialtyPagination specialtiesPagination) {
    List<SearchElementSpecialtyResponseResource> specialtiesResponse = new ArrayList<>();
    for (Specialty specialty : specialtiesPagination.getSpecialties()) {
      specialtiesResponse.add(mapResponseElement(specialty));
    }
    return SearchSpecialtyResponseResource.builder()
        .pagination(paginationMapper.map(specialtiesPagination.getPagination()))
        .specialties(specialtiesResponse)
        .build();
  }

  public SearchElementSpecialtyResponseResource mapResponseElement(Specialty specialty) {
    return SearchElementSpecialtyResponseResource.builder()
        .id(specialty.getId())
        .name(specialty.getName())
        .build();
  }
}
