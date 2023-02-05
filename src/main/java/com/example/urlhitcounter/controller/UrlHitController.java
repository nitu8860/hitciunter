package com.example.urlhitcounter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.urlhitcounter.service.UrlHitService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    private UrlHitService urlHitService;

    @GetMapping("/username/{username}/count")
    public ResponseEntity<Map<String, String>> getHitCount(@PathVariable("username") String username) {
        int count = urlHitService.getCount(username);
        Map<String, String> result = new HashMap<>();
        result.put("username", username);
        result.put("hitcount", Integer.toString(count));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}






