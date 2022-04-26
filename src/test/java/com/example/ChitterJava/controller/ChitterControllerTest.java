package com.example.ChitterJava.controller;

import com.example.ChitterJava.model.Peep;
import com.example.ChitterJava.service.PeepsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ChitterController.class)
public class ChitterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeepsService allPeeps;

    @Test
    public void getPeep() throws Exception {

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

    @Test
    public void getAllPeeps() throws Exception {

        when(allPeeps.all()).thenReturn(new Peep(2, "henry", "no"));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-peeps")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"user\":\"henry\",\"message\":\"no\"}"))
                .andReturn();
        assertEquals("{\"id\":2,\"user\":\"henry\",\"message\":\"no\"}", result
                .getResponse()
                .getContentAsString());
    }

}