package es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SpecialtySpecification {

  public Specification<SpecialtyEntity> nameLike(String query) {
    return (root, criteriaQuery, criteriaBuilder) ->
        criteriaBuilder.like(
            criteriaBuilder.upper(root.get(SpecialtyEntity_.name)),
            "%" + query.toUpperCase() + "%");
  }
}
