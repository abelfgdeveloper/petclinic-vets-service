package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.delete;

import es.abelfgdeveloper.petclinic.vet.adapter.out.persistence.SpringDataVetRepository;
import es.abelfgdeveloper.petclinic.vet.adapter.out.persistence.VetEntity;
import es.abelfgdeveloper.petclinic.vet.domain.model.VetMother;
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
class DeleteVetControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private SpringDataVetRepository springDataVetRepository;

  @Test
  void test_delete() throws Exception {
    // given
    springDataVetRepository.deleteAll();
    String endpoint = "/v1/vets/{vetId}";
    VetEntity vet = VetMother.vetEntity();
    springDataVetRepository.save(vet);

    // when
    MockHttpServletResponse httpResponse =
        mockMvc
            .perform(MockMvcRequestBuilders.delete(endpoint, vet.getId()))
            .andReturn()
            .getResponse();

    // then
    Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), httpResponse.getStatus());
    Assertions.assertTrue(springDataVetRepository.findById(vet.getId()).isEmpty());
  }
}
