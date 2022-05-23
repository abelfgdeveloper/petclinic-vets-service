package es.abelfgdeveloper.petclinic.specialty.domain.model;

import es.abelfgdeveloper.core.pagination.domain.PaginationOut;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SpecialtyPagination {

  private PaginationOut pagination;
  private List<Specialty> specialties;
}
