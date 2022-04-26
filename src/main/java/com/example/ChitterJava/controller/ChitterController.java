package com.example.ChitterJava.controller;

import com.example.ChitterJava.service.PeepsService;
import com.example.ChitterJava.model.Peep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class ChitterController {

    @Autowired
    PeepsService peepsService;

    @GetMapping(value="/all-peeps")
    public Peep getAllPeeps() {
        return peepsService.all();
    }

    @GetMapping(value="/peep")
    public Peep getPeep() {
        return new Peep(1, "mary", "hi world");
    }




}
