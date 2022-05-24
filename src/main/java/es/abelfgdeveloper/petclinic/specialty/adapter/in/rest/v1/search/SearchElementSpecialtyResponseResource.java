package es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.v1.search;

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
public class SearchElementSpecialtyResponseResource {

  private String id;
  private String name;
}
