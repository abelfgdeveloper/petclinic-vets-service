package es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(SpecialtyJpaEntity.class)
public class SpecialtyJpaEntity_ {

  public static volatile SingularAttribute<SpecialtyJpaEntity, String> id;
  public static volatile SingularAttribute<SpecialtyJpaEntity, String> name;
}
