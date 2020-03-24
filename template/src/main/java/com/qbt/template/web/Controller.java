package com.qbt.template.web;

import com.qbt.template.domain.Template;
import com.qbt.template.repository.TemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  @Autowired
  TemplateMapper templateMapper;

  @GetMapping("/hello-world")
  public ResponseEntity first() {
    Template template = new Template();
    template.setName("qbt");
    templateMapper.add(template);
    return ResponseEntity.ok(new Result("hello,world"));
  }

}
