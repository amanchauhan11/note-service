package com.notes.noteservice.controller;

import com.notes.noteservice.dto.SignupDto;
import com.notes.noteservice.dto.UserDto;
import com.notes.noteservice.exception.AppException;
import com.notes.noteservice.response.Response;
import com.notes.noteservice.response.Status;
import com.notes.noteservice.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private IUserService userService;

  @GetMapping
  Response<UserDto> get(Principal principal){
    log.info("Got call to get details for user: {}", principal.getName());
    UserDto userDto = userService.getUserDetails(principal.getName());
    return new Response<>(userDto, Status.SUCCESS);
  }

  @PostMapping("/signup")
  Response signup(@RequestBody SignupDto userDto){
    log.info("Got call to sign up user: {}", userDto.getEmail());
    if(!userService.exists(userDto.getEmail())){
      userService.createUser(userDto);
    } else {
      throw new AppException(Status.USER_EXISTS);
    }
    return new Response<>(null, Status.SUCCESS);
  }
}
