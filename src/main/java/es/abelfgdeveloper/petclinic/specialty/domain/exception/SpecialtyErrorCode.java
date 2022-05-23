package es.abelfgdeveloper.petclinic.specialty.domain.exception;

import es.abelfgdeveloper.core.exception.domain.DomainError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpecialtyErrorCode {

  private static final String CONTEXT = "PETCLINIC";

  public static final DomainError BODY_NULL = build("REQUEST_BODY_NOT_NULL");
  public static final DomainError ID_NULL = build("SPECIALTY_ID_NOT_NULL");
  public static final DomainError NAME_NULL = build("SPECIALTY_NAME_NOT_NULL");
  public static final DomainError NAME_LENGTH = build("SPECIALTY_NAME_LENGTH");
  public static final DomainError NOT_FOUND = build("SPECIALTY_NOT_FOUND");

  private static DomainError build(String code) {
    return new DomainError(CONTEXT, code);
  }
}
