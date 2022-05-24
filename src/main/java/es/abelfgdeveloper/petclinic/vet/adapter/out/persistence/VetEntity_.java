package es.abelfgdeveloper.petclinic.vet.adapter.out.persistence;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(VetEntity.class)
public class VetEntity_ {

  public static volatile SingularAttribute<VetEntity, String> id;
  public static volatile SingularAttribute<VetEntity, String> firstName;
  public static volatile SingularAttribute<VetEntity, String> lastName;
  public static volatile ListAttribute<VetEntity, String> specialties;
}
