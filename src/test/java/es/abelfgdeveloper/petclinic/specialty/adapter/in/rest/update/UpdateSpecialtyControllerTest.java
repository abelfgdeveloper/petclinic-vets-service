package es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.update;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence.SpecialtyJpaEntity;
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
class UpdateSpecialtyControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;
  @Autowired private SpringDataSpecialtyRepository springDataSpecialtyRepository;

  @Test
  void test_update() throws Exception {
    // given
    springDataSpecialtyRepository.deleteAll();
    String endpoint = "/v1/specialties/{specialtyId}";
    SpecialtyJpaEntity specialty = SpecialtyMother.specialtyJpaEntity();
    springDataSpecialtyRepository.save(specialty);
    UpdateSpecialtyRequestResource request = SpecialtyMother.updateSpecialtyRequestResource();

    // when
    MockHttpServletResponse httpResponse =
        mockMvc
            .perform(
                MockMvcRequestBuilders.put(endpoint, specialty.getId())
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
            .andReturn()
            .getResponse();

    // then
    Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), httpResponse.getStatus());
    Assertions.assertEquals(
        request.getName(),
        springDataSpecialtyRepository.findById(specialty.getId()).get().getName());
  }
}
