package es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.v1.delete;

import es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence.SpecialtyEntity;
import es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence.SpringDataSpecialtyRepository;
import es.abelfgdeveloper.petclinic.specialty.domain.model.SpecialtyMother;
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
class DeleteSpecialtyControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private SpringDataSpecialtyRepository springDataSpecialtyRepository;

  @Test
  void test_delete() throws Exception {
    // given
    springDataSpecialtyRepository.deleteAll();
    String endpoint = "/v1/specialties/{specialtyId}";
    SpecialtyEntity specialty = SpecialtyMother.specialtyEntity();
    springDataSpecialtyRepository.save(specialty);

    // when
    MockHttpServletResponse httpResponse =
        mockMvc
            .perform(MockMvcRequestBuilders.delete(endpoint, specialty.getId()))
            .andReturn()
            .getResponse();

    // then
    Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), httpResponse.getStatus());
    Assertions.assertTrue(springDataSpecialtyRepository.findById(specialty.getId()).isEmpty());
  }
}
