package es.abelfgdeveloper.petclinic.specialty.domain.exception;

import es.abelfgdeveloper.core.exception.domain.NotFoundException;

public class SpecialtyNotFoundException extends NotFoundException {

  private static final long serialVersionUID = -4932272949663802697L;

  public SpecialtyNotFoundException() {
    super(SpecialtyErrorCode.NOT_FOUND);
  }
}
