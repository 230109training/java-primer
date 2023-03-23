package com.example.introtospringboot.controllers;

import com.example.introtospringboot.dto.MessageDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping(
       path = "/health",
       method = RequestMethod.GET
    )
    public MessageDTO helloWorld() {
        return new MessageDTO("Hello World");
    }

}
