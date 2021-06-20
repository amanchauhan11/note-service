package com.notes.noteservice.service;

import com.notes.noteservice.dto.NoteDto;
import com.notes.noteservice.entity.User;
import com.notes.noteservice.exception.AppException;

import java.util.List;

public interface INoteService {

  void createOrUpdate(NoteDto noteDto, String email);

  List<NoteDto> getNotesForUser(User user);

  void delete(Integer noteId, String email) throws AppException;

}
