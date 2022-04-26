package com.example.ChitterJava.controller;

import com.example.ChitterJava.service.ChitterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ChitterController.class)
public class ChitterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllPeeps() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/peeps")
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