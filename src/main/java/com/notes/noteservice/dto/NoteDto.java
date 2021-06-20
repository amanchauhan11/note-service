package com.notes.noteservice.dto;

import com.notes.noteservice.entity.Note;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class NoteDto {
  Integer id;
  String title;
  String body;
  Timestamp createdOn;

  public NoteDto(Note note) {
    this.id = note.getId();
    this.title = note.getTitle();
    this.body = note.getBody();
    this.createdOn = note.getCreatedOn();
  }
}
