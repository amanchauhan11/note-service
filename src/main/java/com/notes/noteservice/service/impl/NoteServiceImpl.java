package com.notes.noteservice.service.impl;

import com.notes.noteservice.dto.NoteDto;
import com.notes.noteservice.entity.Note;
import com.notes.noteservice.entity.User;
import com.notes.noteservice.exception.AppException;
import com.notes.noteservice.repository.NoteRepository;
import com.notes.noteservice.response.Status;
import com.notes.noteservice.service.INoteService;
import com.notes.noteservice.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements INoteService {

  @Autowired
  private NoteRepository noteRepository;

  @Autowired
  private IUserService userService;

  @Override
  public void createOrUpdate(NoteDto noteDto, String email) {
    Note note = new Note();
    BeanUtils.copyProperties(noteDto, note);
    note.setUser(userService.getUser(email));
    noteRepository.save(note);
  }

  @Override
  public List<NoteDto> getNotesForUser(User user) {
    return user.getNotes().stream().map(NoteDto::new).collect(Collectors.toList());
  }

  @Override
  public void delete(Integer noteId, String email) {
    User user = userService.getUser(email);
    if(user.getNotes().stream().map(Note::getId).collect(Collectors.toList()).contains(noteId)){
      noteRepository.deleteById(noteId);
    } else {
      throw new AppException(Status.NOT_ALLOWED);
    }
  }

}
