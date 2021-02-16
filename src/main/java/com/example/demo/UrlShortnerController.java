package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/url")
public class UrlShortnerController {

    @Autowired
    private URLShortnerService urlShortnerService;

    @GetMapping("/getLongURL/{short_url}")
    public String getLongURL(@RequestParam String short_url)
    {
        return urlShortnerService.getLongURL(short_url);
    }

    @PostMapping("/getShortUrl")
    public String getShortURL(@RequestBody URL url){
        return(urlShortnerService.getShortURL(url));

    }
}
