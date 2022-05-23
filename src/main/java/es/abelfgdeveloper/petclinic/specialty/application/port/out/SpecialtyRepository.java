package es.abelfgdeveloper.petclinic.specialty.application.port.out;

import es.abelfgdeveloper.core.pagination.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;
import es.abelfgdeveloper.petclinic.specialty.domain.model.SpecialtyPagination;
import java.util.Optional;

public interface SpecialtyRepository {

  Specialty create(Specialty specialty);

  Specialty update(Specialty specialty);

  void deleteById(String id);

  Optional<Specialty> findById(String id);

  Optional<Specialty> findByName(String name);

  SpecialtyPagination search(PaginationIn pagination, SpecialtyCriteria criteria);
}
