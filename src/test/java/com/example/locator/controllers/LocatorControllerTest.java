package com.example.locator.controllers;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

class LocatorControllerTest {

    @Test
    void locator() throws MalformedURLException {
        LocatorController locatorController = new LocatorController();
        String response = locatorController.locator(27.2046,77.4977);
        assertEquals("Finding restaurants around (27.2046, 77.4977)", response);
    }
}