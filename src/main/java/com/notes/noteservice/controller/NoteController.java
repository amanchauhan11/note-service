package com.notes.noteservice.controller;

import com.notes.noteservice.dto.NoteDto;
import com.notes.noteservice.response.Response;
import com.notes.noteservice.response.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
public class NoteController {

  @GetMapping
  public Response<NoteDto> get() {
    NoteDto nDto = NoteDto.builder().id(1).title("note 1").body("body 1").build();
    return new Response<>(nDto, Status.SUCCESS);
  }
}
