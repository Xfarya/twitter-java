package com.example.ChitterJava.controller;

import com.example.ChitterJava.model.Peep;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChitterController {
    @GetMapping(value="/peeps")
    public Peep allPeeps() {
        return new Peep(1, "mary", "hi world");
    }
}
