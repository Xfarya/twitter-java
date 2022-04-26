package com.example.ChitterJava.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ChitterController.class)
public class ChitterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllPeeps() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/peep")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                     .andExpect(status().isOk())
                     .andExpect(content().json("{\"id\":1,\"user\":\"mary\",\"message\":\"hi world\"}"))
                     .andReturn();
        assertEquals("{\"id\":1,\"user\":\"mary\",\"message\":\"hi world\"}", result
                .getResponse()
                .getContentAsString());
    }

}