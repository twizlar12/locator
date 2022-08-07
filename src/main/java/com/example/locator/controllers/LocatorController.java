package com.example.locator.controllers;

import com.example.locator.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class LocatorController {
    String ACCESS_TOKEN = "access_token=pk.eyJ1IjoidHdpemxhcjEyIiwiYSI6ImNsNjVvZnphYzA4NmUzYm5vbno4ZHhhNG0ifQ.TnvXUSGteqOINmkSsa2IHQ";

    @GetMapping("/locator")
    public String locator(@RequestParam(defaultValue = "0") Double latitude,
                          @RequestParam(defaultValue = "0") Double longitude) throws MalformedURLException {

        URL url = new URL("https://api.mapbox.com/geocoding/v5/mapbox.places/");
        String mapboxURL = String.format(url + "%s,%s.json?" + ACCESS_TOKEN, latitude, longitude);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Restaurant> response = restTemplate.getForEntity(mapboxURL, Restaurant.class);

        System.out.println("RETURN FROM MAPBOX: " + response);

        return response.getBody().getPlaceName();
    }
}
