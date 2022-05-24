package es.abelfgdeveloper.petclinic.vet.application.port.in.search;

import es.abelfgdeveloper.petclinic.vet.domain.model.VetPagination;

public interface SearchVetUseCase {

  VetPagination execute(SearchVetQuery query);
}
