package es.abelfgdeveloper.petclinic.vet.domain.model;

import es.abelfgdeveloper.core.pagination.domain.PaginationOut;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VetPagination {

  private PaginationOut pagination;
  private List<Vet> vets;
}
