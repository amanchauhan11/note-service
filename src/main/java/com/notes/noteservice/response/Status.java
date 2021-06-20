package com.notes.noteservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
  SUCCESS(1000, "Success"),
  PROCESSING_ERROR(999, "Processing error"),
  NOT_ALLOWED(998, "Not Allowed"),
  USER_EXISTS(997, "User already exists");

  private final Integer code;
  private final String desc;

}
