package es.abelfgdeveloper.petclinic.specialty.domain.model;

import es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.v1.create.CreateSpecialtyRequestResource;
import es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.v1.update.UpdateSpecialtyRequestResource;
import es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence.SpecialtyEntity;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpecialtyMother {

  public static SpecialtyEntity specialtyEntity() {
    return SpecialtyEntity.builder().id(UUID.randomUUID().toString()).name("name jpa").build();
  }

  public static CreateSpecialtyRequestResource createSpecialtyRequestResource() {
    return CreateSpecialtyRequestResource.builder().name("name create").build();
  }

  public static UpdateSpecialtyRequestResource updateSpecialtyRequestResource() {
    return UpdateSpecialtyRequestResource.builder().name("name update").build();
  }
}
