package com.ps.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class M0application {

    public static void main(String[] args){
        SpringApplication.run(M0application.class, args);
    }

    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public String greeting(){
        return "Hello!";
    }

}
