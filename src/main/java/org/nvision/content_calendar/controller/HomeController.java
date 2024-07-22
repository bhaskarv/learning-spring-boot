package org.nvision.content_calendar.controller;

import org.nvision.content_calendar.config.ContentCalendarProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

//    @Value("${cc.welcomeMessage: Default Welcome Message}")
//    private String welconeMessage;
//
//    @Value("${cc.about}")
//    private String about;

    private ContentCalendarProperties contentCalendarProperties;

    public HomeController(ContentCalendarProperties contentCalendarProperties) {
        this.contentCalendarProperties = contentCalendarProperties;
    }

    @GetMapping("/")
    public ContentCalendarProperties home() {
        //return "Hello  ";
        //return Map.of("welcomeMessage", welconeMessage, "about",about);
        return contentCalendarProperties;
    }
}
