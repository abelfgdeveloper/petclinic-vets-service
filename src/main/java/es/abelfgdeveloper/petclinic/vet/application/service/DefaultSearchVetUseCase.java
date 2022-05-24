package es.abelfgdeveloper.petclinic.vet.application.service;

import es.abelfgdeveloper.petclinic.vet.application.port.in.search.SearchVetQuery;
import es.abelfgdeveloper.petclinic.vet.application.port.in.search.SearchVetUseCase;
import es.abelfgdeveloper.petclinic.vet.application.port.out.VetCriteria;
import es.abelfgdeveloper.petclinic.vet.application.port.out.VetRepository;
import es.abelfgdeveloper.petclinic.vet.domain.model.VetPagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultSearchVetUseCase implements SearchVetUseCase {

  private final VetRepository vetRepository;

  @Override
  public VetPagination execute(SearchVetQuery query) {
    VetCriteria criteria = VetCriteria.builder().query(query.getQuery()).build();

    return vetRepository.search(query.getPagination(), criteria);
  }
}
