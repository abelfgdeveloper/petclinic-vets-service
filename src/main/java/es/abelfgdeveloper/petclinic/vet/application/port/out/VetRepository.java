package es.abelfgdeveloper.petclinic.vet.application.port.out;

import es.abelfgdeveloper.core.pagination.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;
import es.abelfgdeveloper.petclinic.vet.domain.model.VetPagination;
import java.util.Optional;

public interface VetRepository {

  Vet create(Vet vet);

  Vet update(Vet vet);

  void deleteById(String id);

  Optional<Vet> findById(String id);

  VetPagination search(PaginationIn pagination, VetCriteria criteria);
}
