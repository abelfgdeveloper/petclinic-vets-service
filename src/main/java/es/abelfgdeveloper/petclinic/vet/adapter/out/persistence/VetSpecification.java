package es.abelfgdeveloper.petclinic.vet.adapter.out.persistence;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class VetSpecification {

  public Specification<VetEntity> firstNameOrLastNameLike(String query) {
    return firstNameLike(query).or(lastNameLike(query));
  }

  public Specification<VetEntity> firstNameLike(String query) {
    return (root, criteriaQuery, criteriaBuilder) ->
        criteriaBuilder.like(
            criteriaBuilder.upper(root.get(VetEntity_.firstName)), "%" + query.toUpperCase() + "%");
  }

  public Specification<VetEntity> lastNameLike(String query) {
    return (root, criteriaQuery, criteriaBuilder) ->
        criteriaBuilder.like(
            criteriaBuilder.upper(root.get(VetEntity_.lastName)), "%" + query.toUpperCase() + "%");
  }
}
