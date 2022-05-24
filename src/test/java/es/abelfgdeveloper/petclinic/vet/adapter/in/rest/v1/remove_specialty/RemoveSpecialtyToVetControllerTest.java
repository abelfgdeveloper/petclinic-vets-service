package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.remove_specialty;

import es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence.SpecialtyJpaEntity;
import es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence.SpringDataSpecialtyRepository;
import es.abelfgdeveloper.petclinic.specialty.domain.model.SpecialtyMother;
import es.abelfgdeveloper.petclinic.vet.adapter.out.persistence.SpringDataVetRepository;
import es.abelfgdeveloper.petclinic.vet.adapter.out.persistence.VetEntity;
import es.abelfgdeveloper.petclinic.vet.domain.model.VetMother;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class RemoveSpecialtyToVetControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private SpringDataVetRepository springDataVetRepository;
  @Autowired private SpringDataSpecialtyRepository springDataSpecialtyRepository;

  @Test
  void test_removeSpecialty() throws Exception {
    // given
    springDataVetRepository.deleteAll();
    springDataSpecialtyRepository.deleteAll();
    String endpoint = "/v1/vets/{vetId}/specialties/{specialtyId}";

    VetEntity vet = VetMother.vetEntity();
    SpecialtyJpaEntity specialty = SpecialtyMother.specialtyJpaEntity();
    springDataSpecialtyRepository.save(specialty);
    vet.getSpecialties().add(specialty.getId());
    springDataVetRepository.save(vet);

    // when
    MockHttpServletResponse httpResponse =
        mockMvc
            .perform(MockMvcRequestBuilders.delete(endpoint, vet.getId(), specialty.getId()))
            .andReturn()
            .getResponse();

    // then
    Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), httpResponse.getStatus());
    Optional<VetEntity> vetEntity = springDataVetRepository.findById(vet.getId());
    Assertions.assertEquals(0, vetEntity.get().getSpecialties().size());
  }
}
