package com.notes.noteservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteDto {
  Integer id;
  String title;
  String body;
}
