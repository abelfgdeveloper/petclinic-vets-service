package es.abelfgdeveloper.petclinic.specialty.application.port.in.search;

import es.abelfgdeveloper.petclinic.specialty.domain.model.SpecialtyPagination;

public interface SearchSpecialtyUseCase {

  SpecialtyPagination execute(SearchSpecialtyQuery query);
}
