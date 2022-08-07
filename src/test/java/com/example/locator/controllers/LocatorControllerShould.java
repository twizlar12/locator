package com.example.locator.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LocatorController.class)
class LocatorControllerShould {

    @Autowired
    private MockMvc mvc;

    @Test
    public void returnSuccess() throws Exception {
        mvc.perform(get("/locator"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void makeACallToMapbox() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/locator");
        MvcResult result = mvc.perform(request).andReturn();
         assertThat(result.getResponse().getContentAsString(), containsString("Mapbox"));
//         assertEquals("Finding restaurants around (0.0, 0.0)", result.getResponse().getContentAsString());
    }

    @Test
    public void returnRestaurantGivenCoordinates() throws Exception {
        mvc.perform(get("/locator?latitude=-0.009483841970961748&longitude=51.560515568709604"))
                .andExpect(content().string(containsString("Five Lads")));
    }
}