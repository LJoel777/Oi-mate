package hu.joel.laczkovszki.qa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QAndAController {

    @GetMapping("/test")
    public String test() {
        return "This is a test api";
    }
}
