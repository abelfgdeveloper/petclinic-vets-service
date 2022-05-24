package es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence;

import es.abelfgdeveloper.core.pagination.adapter.out.persistence.PaginationMapper;
import es.abelfgdeveloper.core.pagination.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.specialty.application.port.out.SpecialtyCriteria;
import es.abelfgdeveloper.petclinic.specialty.application.port.out.SpecialtyRepository;
import es.abelfgdeveloper.petclinic.specialty.domain.exception.SpecialtyNotFoundException;
import es.abelfgdeveloper.petclinic.specialty.domain.model.Specialty;
import es.abelfgdeveloper.petclinic.specialty.domain.model.SpecialtyPagination;
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
public class SpecialtyPersistenceAdapter implements SpecialtyRepository {

  private final SpringDataSpecialtyRepository specialtyRepository;
  private final SpecialtySpecification specialtySpecification;
  private final SpecialtyMapper specialtyMapper;
  private final PaginationMapper paginationMapper;

  @Override
  public Specialty create(Specialty specialty) {
    SpecialtyEntity specialtyToSave =
        SpecialtyEntity.builder().id(specialty.getId()).name(specialty.getName()).build();
    return specialtyMapper.map(specialtyRepository.save(specialtyToSave));
  }

  @Override
  public Specialty update(Specialty specialty) {
    SpecialtyEntity specialtySaved =
        specialtyRepository
            .findById(specialty.getId())
            .orElseThrow(SpecialtyNotFoundException::new);
    specialtySaved.setName(specialty.getName());
    return specialtyMapper.map(specialtyRepository.save(specialtySaved));
  }

  @Override
  public void deleteById(String id) {
    specialtyRepository.deleteById(id);
  }

  @Override
  public Optional<Specialty> findById(String id) {
    return specialtyRepository.findById(id).map(specialtyMapper::map);
  }

  @Override
  public Optional<Specialty> findByName(String name) {
    return specialtyRepository.findByName(name).map(specialtyMapper::map);
  }

  @Override
  public SpecialtyPagination search(PaginationIn pagination, SpecialtyCriteria criteria) {
    PageRequest pageRequest = paginationMapper.map(pagination);
    Page<SpecialtyEntity> pageResult = null;
    Optional<Specification<SpecialtyEntity>> specification = buildSpecification(criteria);
    if (specification.isPresent()) {
      pageResult = specialtyRepository.findAll(specification.get(), pageRequest);
    } else {
      pageResult = specialtyRepository.findAll(pageRequest);
    }

    List<Specialty> specialties = new ArrayList<>();
    for (SpecialtyEntity specialtyEntity : pageResult.getContent()) {
      specialties.add(specialtyMapper.map(specialtyEntity));
    }

    return SpecialtyPagination.builder()
        .pagination(paginationMapper.map(pageResult))
        .specialties(specialties)
        .build();
  }

  private Optional<Specification<SpecialtyEntity>> buildSpecification(SpecialtyCriteria criteria) {
    Specification<SpecialtyEntity> specification = null;
    if (criteria.getName() != null) {
      specification = specialtySpecification.nameLike(criteria.getName());
    }
    return Optional.ofNullable(specification);
  }
}
