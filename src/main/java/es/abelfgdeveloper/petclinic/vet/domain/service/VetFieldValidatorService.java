package es.abelfgdeveloper.petclinic.vet.domain.service;

import es.abelfgdeveloper.core.exception.domain.ValidationException;
import es.abelfgdeveloper.petclinic.vet.domain.exception.VetErrorCode;
import org.springframework.stereotype.Component;

@Component
public class VetFieldValidatorService {

  public void validateId(String id) {
    if (id == null) {
      throw new ValidationException(VetErrorCode.ID_NULL);
    }
  }

  public void validateFirstName(String firstName) {
    if (firstName == null) {
      throw new ValidationException(VetErrorCode.FIRST_NAME_NULL);
    }
    if (firstName.trim().length() < 3 || firstName.trim().length() > 25) {
      throw new ValidationException(VetErrorCode.FIRST_NAME_LENGTH);
    }
  }

  public void validateLastName(String lastName) {
    if (lastName == null) {
      throw new ValidationException(VetErrorCode.LAST_NAME_NULL);
    }
    if (lastName.trim().length() < 3 || lastName.trim().length() > 25) {
      throw new ValidationException(VetErrorCode.LAST_NAME_LENGTH);
    }
  }
}
