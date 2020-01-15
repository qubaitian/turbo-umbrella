package com.qbt.template;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
public class controller {
    @GetMapping("/time")
    public Time getTime(){
        Time time = new Time();
        time.setValue(new Date().toString());
        System.out.println(time);
        return time;
    }
}
