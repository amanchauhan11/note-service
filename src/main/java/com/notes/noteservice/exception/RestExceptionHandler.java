package com.notes.noteservice.exception;

import com.notes.noteservice.response.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(value = {AppException.class})
  public Response handleException(AppException appException) {
    return new Response<>(null, appException.getStatus());
  }
}
