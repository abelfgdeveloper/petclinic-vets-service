package es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "specialties")
public class SpecialtyEntity implements Serializable {

  private static final long serialVersionUID = -8342815897153870981L;

  @EqualsAndHashCode.Include @Id private String id;

  @Setter private String name;
}
