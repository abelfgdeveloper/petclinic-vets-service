package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.find;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FindVetResponseResource {

  private String id;
  private String firstName;
  private String lastName;
  private List<String> specialties;
}
