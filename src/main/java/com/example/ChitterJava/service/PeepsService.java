package com.example.ChitterJava.service;

import com.example.ChitterJava.model.Peep;
import org.springframework.stereotype.Component;

@Component
public class PeepsService {
        public Peep all() {
            return new Peep(1, "mary", "hi world");
        }
}
