package es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence.SpringDataSpecialtyRepository;
import es.abelfgdeveloper.petclinic.specialty.domain.model.SpecialtyMother;
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
class CreateSpecialtyControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;
  @Autowired private SpringDataSpecialtyRepository springDataSpecialtyRepository;

  @Test
  void test_create() throws Exception {
    // given
    springDataSpecialtyRepository.deleteAll();
    String endpoint = "/v1/specialties";
    CreateSpecialtyRequestResource request = SpecialtyMother.createSpecialtyRequestResource();

    // when
    MockHttpServletResponse httpResponse =
        mockMvc
            .perform(
                MockMvcRequestBuilders.post(endpoint)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
            .andReturn()
            .getResponse();

    CreateSpecialtyResponseResource response =
        objectMapper.readValue(
            httpResponse.getContentAsString(), CreateSpecialtyResponseResource.class);

    // then
    Assertions.assertEquals(HttpStatus.CREATED.value(), httpResponse.getStatus());
    Assertions.assertNotNull(response.getId());
    Assertions.assertTrue(springDataSpecialtyRepository.findById(response.getId()).isPresent());
  }
}
