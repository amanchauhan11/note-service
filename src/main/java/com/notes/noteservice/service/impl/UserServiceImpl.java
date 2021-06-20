package com.notes.noteservice.service.impl;

import com.notes.noteservice.dto.SignupDto;
import com.notes.noteservice.dto.UserDto;
import com.notes.noteservice.entity.User;
import com.notes.noteservice.repository.UserRepository;
import com.notes.noteservice.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDto getUserDetails(String email) {
    return new UserDto(userRepository.findByEmail(email));
  }

  @Override
  public User getUser(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public Boolean exists(String email) {
    return Objects.nonNull(userRepository.findByEmail(email));
  }

  @Override
  public void createUser(SignupDto userDto) {
    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    userRepository.save(user);
  }
}
