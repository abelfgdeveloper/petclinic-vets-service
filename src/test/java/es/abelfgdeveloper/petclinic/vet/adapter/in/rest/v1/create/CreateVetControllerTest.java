package es.abelfgdeveloper.petclinic.vet.adapter.in.rest.v1.create;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CreateVetControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;
  @Autowired private SpringDataVetRepository springDataVetRepository;

  @Test
  void test_create() throws Exception {
    // given
    springDataVetRepository.deleteAll();
    String endpoint = "/v1/vets";
    CreateVetRequestResource request = VetMother.createVetRequestResource();

    // when
    MockHttpServletResponse httpResponse =
        mockMvc
            .perform(
                MockMvcRequestBuilders.post(endpoint)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
            .andReturn()
            .getResponse();

    CreateVetResponseResource response =
        objectMapper.readValue(httpResponse.getContentAsString(), CreateVetResponseResource.class);

    // then
    Assertions.assertEquals(HttpStatus.CREATED.value(), httpResponse.getStatus());
    Assertions.assertNotNull(response.getId());
    Optional<VetEntity> vetEntity = springDataVetRepository.findById(response.getId());
    Assertions.assertTrue(vetEntity.isPresent());
    Assertions.assertEquals(request.getFirstName(), vetEntity.get().getFirstName());
    Assertions.assertEquals(request.getLastName(), vetEntity.get().getLastName());
  }
}
