package es.abelfgdeveloper.petclinic.specialty.application.service;

import es.abelfgdeveloper.petclinic.specialty.application.port.in.search.SearchSpecialtyQuery;
import es.abelfgdeveloper.petclinic.specialty.application.port.in.search.SearchSpecialtyUseCase;
import es.abelfgdeveloper.petclinic.specialty.application.port.out.SpecialtyCriteria;
import es.abelfgdeveloper.petclinic.specialty.application.port.out.SpecialtyRepository;
import es.abelfgdeveloper.petclinic.specialty.domain.model.SpecialtyPagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultSearchSpecialtyUseCase implements SearchSpecialtyUseCase {

  private final SpecialtyRepository specialtyRepository;

  @Override
  public SpecialtyPagination execute(SearchSpecialtyQuery query) {
    SpecialtyCriteria criteria = SpecialtyCriteria.builder().name(query.getName()).build();
    return specialtyRepository.search(query.getPagination(), criteria);
  }
}
