package com.notes.noteservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
  SUCCESS(1000, "Success"),
  PROCESSING_ERROR(999, "Processing error");

  private final Integer code;
  private final String desc;

}
