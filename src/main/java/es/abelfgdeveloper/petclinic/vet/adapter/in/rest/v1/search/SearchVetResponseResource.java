package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.search;

import es.abelfgdeveloper.core.pagination.adapter.in.rest.PaginationResponseResource;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SearchVetResponseResource {

  private PaginationResponseResource pagination;
  private List<SearchElementVetResponseResource> vets;
}
