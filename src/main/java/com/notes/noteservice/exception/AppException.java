package com.notes.noteservice.exception;

import com.notes.noteservice.response.Status;
import lombok.Data;

@Data
public class AppException extends RuntimeException{

  private Status status;

  public AppException(Status status){
    super(status.getDesc());
    this.status = status;
  }
}
