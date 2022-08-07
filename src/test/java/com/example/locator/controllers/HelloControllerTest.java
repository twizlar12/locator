package com.example.locator.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    @Test
    void hello() {
        HelloController helloController = new HelloController();
        String response = helloController.hello("World");
        assertEquals("Hello, World", response);
    }
}