package es.abelfgdeveloper.petclinic.specialty.adapter.in.rest.v1.search;

import com.fasterxml.jackson.databind.ObjectMapper;
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
class SearchSpecialtyControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;
  @Autowired private SpringDataSpecialtyRepository springDataSpecialtyRepository;

  @Test
  void test_search() throws Exception {
    // given
    springDataSpecialtyRepository.deleteAll();
    String endpoint = "/v1/specialties";
    SpecialtyEntity specialty = SpecialtyMother.specialtyEntity();
    springDataSpecialtyRepository.save(specialty);

    // when
    MockHttpServletResponse httpResponse =
        mockMvc
            .perform(MockMvcRequestBuilders.get(endpoint, specialty.getId()))
            .andReturn()
            .getResponse();

    SearchSpecialtyResponseResource response =
        objectMapper.readValue(
            httpResponse.getContentAsString(), SearchSpecialtyResponseResource.class);

    // then
    Assertions.assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());
    Assertions.assertEquals(1, response.getSpecialties().size());
    Assertions.assertEquals(specialty.getId(), response.getSpecialties().get(0).getId());
    Assertions.assertEquals(specialty.getName(), response.getSpecialties().get(0).getName());
  }
}
