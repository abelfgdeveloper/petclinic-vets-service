package es.abelfgdeveloper.petclinic.vet.domain.service;

import es.abelfgdeveloper.core.exception.domain.ValidationException;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VetFieldValidatorServiceTest {

  private VetFieldValidatorService vetFieldValidatorService;

  @BeforeEach
  void setUp() {
    vetFieldValidatorService = new VetFieldValidatorService();
  }

  @Test
  void test_validateId() {
    // given
    String id = UUID.randomUUID().toString();

    // when
    vetFieldValidatorService.validateId(id);

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
              vetFieldValidatorService.validateId(id);
            });

    // then
    Assertions.assertEquals("PETCLINIC-VET_ID_NOT_NULL", exception.getMessage());
  }

  @Test
  void test_validateFirstName() {
    // given
    String firstName = "first Name";

    // when
    vetFieldValidatorService.validateFirstName(firstName);

    // then
  }

  @Test
  void test_validateFirstName_nameNull() {
    // given
    String firstName = null;

    // when
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> {
              vetFieldValidatorService.validateFirstName(firstName);
            });

    // then
    Assertions.assertEquals("PETCLINIC-VET_FIRST_NAME_NOT_NULL", exception.getMessage());
  }

  @Test
  void test_validateFirstName_nameMinLength() {
    // given
    String firstName = "aa";

    // when
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> {
              vetFieldValidatorService.validateFirstName(firstName);
            });

    // then
    Assertions.assertEquals("PETCLINIC-VET_FIRST_NAME_LENGTH", exception.getMessage());
  }

  @Test
  void test_validateFirstName_nameMaxLength() {
    // given
    String firstName = "abcdefghijklmnopqrstuvwxyz";

    // when
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> {
              vetFieldValidatorService.validateFirstName(firstName);
            });

    // then
    Assertions.assertEquals("PETCLINIC-VET_FIRST_NAME_LENGTH", exception.getMessage());
  }

  ////////////////////////////////////////

  @Test
  void test_validateLastName() {
    // given
    String lastName = "last Name";

    // when
    vetFieldValidatorService.validateLastName(lastName);

    // then
  }

  @Test
  void test_validateLastName_nameNull() {
    // given
    String lastName = null;

    // when
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> {
              vetFieldValidatorService.validateLastName(lastName);
            });

    // then
    Assertions.assertEquals("PETCLINIC-VET_LAST_NAME_NOT_NULL", exception.getMessage());
  }

  @Test
  void test_validateLastName_nameMinLength() {
    // given
    String lastName = "aa";

    // when
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> {
              vetFieldValidatorService.validateLastName(lastName);
            });

    // then
    Assertions.assertEquals("PETCLINIC-VET_LAST_NAME_LENGTH", exception.getMessage());
  }

  @Test
  void test_validateLastName_nameMaxLength() {
    // given
    String lastName = "abcdefghijklmnopqrstuvwxyz";

    // when
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> {
              vetFieldValidatorService.validateLastName(lastName);
            });

    // then
    Assertions.assertEquals("PETCLINIC-VET_LAST_NAME_LENGTH", exception.getMessage());
  }
}
