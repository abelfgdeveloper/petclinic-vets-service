package es.abelfgdeveloper.petclinic.specialty.domain.service;

import es.abelfgdeveloper.core.exception.domain.ValidationException;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SpecialtyFieldValidatorServiceTest {

  private SpecialtyFieldValidatorService specialtyFieldValidatorService;

  @BeforeEach
  void setUp() {
    specialtyFieldValidatorService = new SpecialtyFieldValidatorService();
  }

  @Test
  void test_validateId() {
    // given
    String id = UUID.randomUUID().toString();

    // when
    specialtyFieldValidatorService.validateId(id);

    // then
  }

  @Test
  void test_validateId_idNull() {
    // given
    String id = null;

    // when
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> {
              specialtyFieldValidatorService.validateId(id);
            });

    // then
    Assertions.assertEquals("PETCLINIC-SPECIALTY_ID_NOT_NULL", exception.getMessage());
  }

  @Test
  void test_validateName() {
    // given
    String name = "name";

    // when
    specialtyFieldValidatorService.validateName(name);

    // then
  }

  @Test
  void test_validateName_nameNull() {
    // given
    String name = null;

    // when
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> {
              specialtyFieldValidatorService.validateName(name);
            });

    // then
    Assertions.assertEquals("PETCLINIC-SPECIALTY_NAME_NOT_NULL", exception.getMessage());
  }

  @Test
  void test_validateName_nameMinLength() {
    // given
    String name = "aa";

    // when
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> {
              specialtyFieldValidatorService.validateName(name);
            });

    // then
    Assertions.assertEquals("PETCLINIC-SPECIALTY_NAME_LENGTH", exception.getMessage());
  }

  @Test
  void test_validateName_nameMaxLength() {
    // given
    String name = "abcdefghijklmnopqrstuvwxyz";

    // when
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> {
              specialtyFieldValidatorService.validateName(name);
            });

    // then
    Assertions.assertEquals("PETCLINIC-SPECIALTY_NAME_LENGTH", exception.getMessage());
  }
}
