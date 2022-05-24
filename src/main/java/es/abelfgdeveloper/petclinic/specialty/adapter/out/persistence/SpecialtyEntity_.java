package es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(SpecialtyEntity.class)
public class SpecialtyEntity_ {

  public static volatile SingularAttribute<SpecialtyEntity, String> id;
  public static volatile SingularAttribute<SpecialtyEntity, String> name;
}
