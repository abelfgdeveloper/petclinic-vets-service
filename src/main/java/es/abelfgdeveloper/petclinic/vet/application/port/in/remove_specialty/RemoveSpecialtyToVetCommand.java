package es.abelfgdeveloper.petclinic.vet.application.port.in.remove_specialty;

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
@EqualsAndHashCode
@ToString
public class RemoveSpecialtyToVetCommand {

  private String vetId;
  private String specialtyId;
}
