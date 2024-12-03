package com.kartik.Learning.Navigator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hidden-feature")
public class EasterEggController {

    @GetMapping("/{number}")
    public ResponseEntity<String> getNumberFact(@PathVariable int number) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://numbersapi.com/" + number + "?json";
        String fact = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(fact);
    }
}
