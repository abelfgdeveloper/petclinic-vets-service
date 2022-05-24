package es.abelfgdeveloper.petclinic.vet.domain.exception;

import es.abelfgdeveloper.core.exception.domain.DomainError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VetErrorCode {

  private static final String CONTEXT = "PETCLINIC";

  public static final DomainError BODY_NULL = build("REQUEST_BODY_NOT_NULL");
  public static final DomainError ID_NULL = build("VET_ID_NOT_NULL");
  public static final DomainError FIRST_NAME_NULL = build("VET_FIRST_NAME_NOT_NULL");
  public static final DomainError FIRST_NAME_LENGTH = build("VET_FIRST_NAME_LENGTH");
  public static final DomainError LAST_NAME_NULL = build("VET_LAST_NAME_NOT_NULL");
  public static final DomainError LAST_NAME_LENGTH = build("VET_LAST_NAME_LENGTH");
  public static final DomainError NOT_FOUND = build("VET_NOT_FOUND");
  public static final DomainError ALREADY_HAS_SPECIALTY = build("VET_ALREADY_HAS_SPECIALTY");
  public static final DomainError NOT_HAVE_SPECIALTY = build("VET_NOT_HAVE_SPECIALTY");

  private static DomainError build(String code) {
    return new DomainError(CONTEXT, code);
  }
}
