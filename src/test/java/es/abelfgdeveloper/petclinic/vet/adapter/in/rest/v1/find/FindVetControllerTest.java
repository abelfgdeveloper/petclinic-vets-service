package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.find;

import com.fasterxml.jackson.databind.ObjectMapper;
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
class FindVetControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;
  @Autowired private SpringDataVetRepository springDataVetRepository;

  @Test
  void test_find() throws Exception {
    // given
    springDataVetRepository.deleteAll();
    String endpoint = "/v1/vets/{vetId}";
    VetEntity vet = VetMother.vetEntity();
    springDataVetRepository.save(vet);

    // when
    MockHttpServletResponse httpResponse =
        mockMvc
            .perform(MockMvcRequestBuilders.get(endpoint, vet.getId()))
            .andReturn()
            .getResponse();

    FindVetResponseResource response =
        objectMapper.readValue(httpResponse.getContentAsString(), FindVetResponseResource.class);

    // then
    Assertions.assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());
    Assertions.assertEquals(vet.getId(), response.getId());
    Assertions.assertEquals(vet.getFirstName(), response.getFirstName());
    Assertions.assertEquals(vet.getLastName(), response.getLastName());
  }
}
