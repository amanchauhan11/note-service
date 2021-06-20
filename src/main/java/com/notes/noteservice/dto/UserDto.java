package com.notes.noteservice.dto;

import com.notes.noteservice.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto {
  String email;
  List<NoteDto> notes;

  public UserDto(User user) {
    this.email = user.getEmail();
    this.notes = user.getNotes().stream().map(NoteDto::new).collect(Collectors.toList());
  }
}
