package com.notes.noteservice.controller;

import com.notes.noteservice.dto.NoteDto;
import com.notes.noteservice.exception.AppException;
import com.notes.noteservice.response.Response;
import com.notes.noteservice.response.Status;
import com.notes.noteservice.service.INoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/note")
public class NoteController {

  @Autowired
  private INoteService noteService;

  @PutMapping
  public Response put(@RequestBody NoteDto noteDto, Principal principal) {
    log.info("Got call to add note: {}, for user: {}", noteDto, principal.getName());
    noteService.createOrUpdate(noteDto, principal.getName());
    return new Response<>(null, Status.SUCCESS);
  }

  @DeleteMapping
  public Response delete(@RequestParam("noteId") Integer noteId, Principal principal)
      throws AppException {
    log.info("Got call to delete note: {}, for user: {}", noteId, principal.getName());
    noteService.delete(noteId, principal.getName());
    return new Response<>(null, Status.SUCCESS);
  }
}
