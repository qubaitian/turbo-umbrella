package com.qbt.template.web;

import lombok.Data;

@Data
public class Result {
  String msg;

  public Result() {
  }

  public Result(String msg) {
    this.msg = msg;
  }
}
