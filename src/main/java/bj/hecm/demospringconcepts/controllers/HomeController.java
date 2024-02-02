package bj.hecm.demospringconcepts.controllers;

import bj.hecm.demospringconcepts.dto.HomeResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @GetMapping("/hello")
    public HomeResponseDto home() {
        return new HomeResponseDto("Hello World!");
    }
}
