package com.shuaiyin.studyplanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{

    @GetMapping("/api/test")
    public String test(){
        return "Study Planner backend is running!";
    }
}