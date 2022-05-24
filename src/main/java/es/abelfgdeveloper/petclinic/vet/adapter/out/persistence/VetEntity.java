package es.abelfgdeveloper.petclinic.vet.adapter.out.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class VetEntity implements Serializable {

  private static final long serialVersionUID = 5135272432765183283L;

  @EqualsAndHashCode.Include @Id private String id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
      name = "vets_specialties",
      joinColumns = @JoinColumn(name = "vet_id", referencedColumnName = "id"))
  @Column(name = "specialty_id")
  private List<String> specialties;
}
