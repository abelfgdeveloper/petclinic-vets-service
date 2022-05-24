package es.abelfgdeveloper.petclinic.vet.adapter.out.persistence;

import es.abelfgdeveloper.core.pagination.adapter.out.persistence.PaginationMapper;
import es.abelfgdeveloper.core.pagination.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.vet.application.port.out.VetCriteria;
import es.abelfgdeveloper.petclinic.vet.application.port.out.VetRepository;
import es.abelfgdeveloper.petclinic.vet.domain.exception.VetNotFoundException;
import es.abelfgdeveloper.petclinic.vet.domain.model.Vet;
import es.abelfgdeveloper.petclinic.vet.domain.model.VetPagination;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class VetPersistenceAdapter implements VetRepository {

  private final SpringDataVetRepository vetRepository;
  private final VetSpecification vetSpecification;
  private final VetMapper vetMapper;
  private final PaginationMapper paginationMapper;

  @Override
  public Vet create(Vet vet) {
    VetEntity vetToSave =
        VetEntity.builder()
            .id(vet.getId())
            .firstName(vet.getFirstName())
            .lastName(vet.getLastName())
            .build();
    return vetMapper.map(vetRepository.save(vetToSave));
  }

  @Override
  public Vet update(Vet vet) {
    VetEntity vetSaved = vetRepository.findById(vet.getId()).orElseThrow(VetNotFoundException::new);
    vetSaved.setFirstName(vet.getFirstName());
    vetSaved.setLastName(vet.getLastName());
    vetSaved.setSpecialties(vet.getSpecialties());
    return vetMapper.map(vetRepository.save(vetSaved));
  }

  @Override
  public void deleteById(String id) {
    vetRepository.deleteById(id);
  }

  @Override
  public Optional<Vet> findById(String id) {
    return vetRepository.findById(id).map(vetMapper::map);
  }

  @Override
  public VetPagination search(PaginationIn pagination, VetCriteria criteria) {
    PageRequest pageRequest = paginationMapper.map(pagination);
    Page<VetEntity> pageResult = null;

    Optional<Specification<VetEntity>> specification = buildSpecification(criteria);
    if (specification.isPresent()) {
      pageResult = vetRepository.findAll(specification.get(), pageRequest);
    } else {
      pageResult = vetRepository.findAll(pageRequest);
    }

    List<Vet> vets = new ArrayList<>();
    for (VetEntity vetEntity : pageResult.getContent()) {
      vets.add(vetMapper.map(vetEntity));
    }

    return VetPagination.builder().pagination(paginationMapper.map(pageResult)).vets(vets).build();
  }

  private Optional<Specification<VetEntity>> buildSpecification(VetCriteria criteria) {
    Specification<VetEntity> specification = null;
    if (criteria.getQuery() != null) {
      specification = vetSpecification.firstNameOrLastNameLike(criteria.getQuery());
    }
    return Optional.ofNullable(specification);
  }
}
