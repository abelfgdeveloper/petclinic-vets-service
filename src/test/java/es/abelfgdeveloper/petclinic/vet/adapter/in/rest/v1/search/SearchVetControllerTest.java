package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.search;

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
class SearchVetControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;
  @Autowired private SpringDataVetRepository springDataVetRepository;

  @Test
  void test_search() throws Exception {
    // given
    springDataVetRepository.deleteAll();
    String endpoint = "/v1/vets";
    VetEntity vet = VetMother.vetEntity();
    springDataVetRepository.save(vet);

    // when
    MockHttpServletResponse httpResponse =
        mockMvc
            .perform(MockMvcRequestBuilders.get(endpoint, vet.getId()))
            .andReturn()
            .getResponse();

    SearchVetResponseResource response =
        objectMapper.readValue(httpResponse.getContentAsString(), SearchVetResponseResource.class);

    // then
    Assertions.assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());
    Assertions.assertEquals(1, response.getVets().size());
    Assertions.assertEquals(vet.getId(), response.getVets().get(0).getId());
    Assertions.assertEquals(vet.getFirstName(), response.getVets().get(0).getFirstName());
    Assertions.assertEquals(vet.getLastName(), response.getVets().get(0).getLastName());
  }
}
