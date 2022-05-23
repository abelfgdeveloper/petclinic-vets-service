package es.abelfgdeveloper.petclinic.specialty.domain.service;

import es.abelfgdeveloper.core.exception.domain.ValidationException;
import es.abelfgdeveloper.petclinic.specialty.domain.exception.SpecialtyErrorCode;
import org.springframework.stereotype.Component;

@Component
public class SpecialtyFieldValidatorService {

  public void validateId(String id) {
    if (id == null) {
      throw new ValidationException(SpecialtyErrorCode.ID_NULL);
    }
  }

  public void validateName(String name) {
    if (name == null) {
      throw new ValidationException(SpecialtyErrorCode.NAME_NULL);
    }
    if (name.trim().length() < 3 || name.trim().length() > 25) {
      throw new ValidationException(SpecialtyErrorCode.NAME_LENGTH);
    }
  }
}
