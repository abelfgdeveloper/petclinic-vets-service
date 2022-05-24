package es.abelfgdeveloper.petclinic.vet.application.port.in.search;

import es.abelfgdeveloper.core.pagination.domain.PaginationIn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SearchVetQuery {

  private PaginationIn pagination;
  private String query;
}
