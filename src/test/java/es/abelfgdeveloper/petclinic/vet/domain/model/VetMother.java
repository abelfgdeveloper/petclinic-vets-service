package es.abelfgdeveloper.petclinic.vet.domain.model;

import es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.create.CreateVetRequestResource;
import es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.update.UpdateVetRequestResource;
import es.abelfgdeveloper.petclinic.vet.adapter.out.persistence.VetEntity;
import java.util.ArrayList;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VetMother {

  public static VetEntity vetEntity() {
    return VetEntity.builder()
        .id(UUID.randomUUID().toString())
        .firstName("first name")
        .lastName("last name")
        .specialties(new ArrayList<>())
        .build();
  }

  public static CreateVetRequestResource createVetRequestResource() {
    return CreateVetRequestResource.builder()
        .firstName("first name create")
        .lastName("last name create")
        .build();
  }

  public static UpdateVetRequestResource updateVetRequestResource() {
    return UpdateVetRequestResource.builder()
        .firstName("first name update")
        .lastName("last name update")
        .build();
  }
}
