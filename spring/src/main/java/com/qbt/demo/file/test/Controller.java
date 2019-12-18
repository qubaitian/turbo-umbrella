package com.qbt.demo.file.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class Controller {
    @GetMapping("/time")
    public String time(){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        return format;
    }
}
