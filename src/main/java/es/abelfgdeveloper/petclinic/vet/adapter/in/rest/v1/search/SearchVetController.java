package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.search;

import es.abelfgdeveloper.core.pagination.adapter.in.rest.PaginationMapper;
import es.abelfgdeveloper.core.pagination.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.vet.application.port.in.search.SearchVetQuery;
import es.abelfgdeveloper.petclinic.vet.application.port.in.search.SearchVetUseCase;
import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;
import es.abelfgdeveloper.petclinic.vet.domain.model.VetPagination;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SearchVetController {

  private final SearchVetUseCase useCase;
  private final PaginationMapper paginationMapper;

  @GetMapping("/v1/vets")
  public SearchVetResponseResource execute(
      @RequestParam(name = "page", required = false) Integer page,
      @RequestParam(name = "size", required = false) Integer size,
      @RequestParam(name = "q", required = false) String q) {
    return mapResponse(useCase.execute(mapRequest(page, size, q)));
  }

  private SearchVetQuery mapRequest(Integer page, Integer size, String q) {
    return SearchVetQuery.builder().pagination(new PaginationIn(page, size)).query(q).build();
  }

  public SearchVetResponseResource mapResponse(VetPagination vetsPagination) {
    List<SearchElementVetResponseResource> vetsResponse = new ArrayList<>();
    for (Vet vet : vetsPagination.getVets()) {
      vetsResponse.add(mapResponseElement(vet));
    }
    return SearchVetResponseResource.builder()
        .pagination(paginationMapper.map(vetsPagination.getPagination()))
        .vets(vetsResponse)
        .build();
  }

  public SearchElementVetResponseResource mapResponseElement(Vet vet) {
    return SearchElementVetResponseResource.builder()
        .id(vet.getId())
        .firstName(vet.getFirstName())
        .lastName(vet.getLastName())
        .build();
  }
}
