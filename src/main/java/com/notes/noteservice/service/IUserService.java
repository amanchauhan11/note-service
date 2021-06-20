package com.notes.noteservice.service;

import com.notes.noteservice.dto.SignupDto;
import com.notes.noteservice.dto.UserDto;
import com.notes.noteservice.entity.User;

public interface IUserService {
  UserDto getUserDetails(String email);
  User getUser(String email);
  Boolean exists(String email);
  void createUser(SignupDto userDto);
}
