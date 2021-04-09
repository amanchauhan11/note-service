package com.notes.noteservice.response;

import lombok.Data;

@Data
public class Response<T> {
  private T responseObject;
  private Integer status;
  private String desc;
  public Response(T responseObject, Status status){
    this.responseObject = responseObject;
    this.status = status.getCode();
    this.desc = status.getDesc();
  }
}
