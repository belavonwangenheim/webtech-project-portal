package de.htw.berlinwebtech.webtechprojectportal.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// @RestController ist Hinweis an Spring Boot das HTTP-Anfragen verarbeitet werden
@RestController
public class Controller {
    @GetMapping("/")
    public ModelAndView showProject() {
        return new ModelAndView ("TempJobOffer");
    }
}
