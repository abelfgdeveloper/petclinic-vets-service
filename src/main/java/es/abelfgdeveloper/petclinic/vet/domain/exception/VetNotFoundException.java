package es.abelfgdeveloper.petclinic.vet.domain.exception;

import es.abelfgdeveloper.core.exception.domain.NotFoundException;

public class VetNotFoundException extends NotFoundException {

  private static final long serialVersionUID = -4932272949663802697L;

  public VetNotFoundException() {
    super(VetErrorCode.NOT_FOUND);
  }
}
