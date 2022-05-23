package es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SpecialtySpecification {

  public Specification<SpecialtyJpaEntity> nameLike(String query) {
    return (root, criteriaQuery, criteriaBuilder) ->
        criteriaBuilder.like(
            criteriaBuilder.upper(root.get(SpecialtyJpaEntity_.name)),
            "%" + query.toUpperCase() + "%");
  }
}
