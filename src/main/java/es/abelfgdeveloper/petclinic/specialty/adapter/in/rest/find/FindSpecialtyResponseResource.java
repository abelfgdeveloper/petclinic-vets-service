package es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.find;

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
public class FindSpecialtyResponseResource {

  private String id;
  private String name;
}
