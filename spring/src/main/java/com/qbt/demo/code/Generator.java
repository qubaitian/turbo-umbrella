package com.qbt.demo.code;

public class Generator {

  //展示但是不存
  public String show(String type) {
    Long next = next(type);
    String s = next + 100000000 + "";
    s = s.substring(1);
    return s;
  }

  //存
  public void commit(Long id) {
    changDr(id);
    addOne();
  }

  //将dr改成1
  private void changDr(Long id) {

  }

  //如果已经没有0的,加一条0的
  private void addOne() {

  }

  //如果已经加过,返回断码最小的
  //如果没加过,新增一条
  private Long next(String type) {
    Code code = find(type);
    if (code == null) {
      code = addNew(type);
    }
    return code.getId();
  }

  //找到
  private Code find(String type) {
    return null;
  }

  //
  private Code addNew(String type) {
    return null;
  }

}
