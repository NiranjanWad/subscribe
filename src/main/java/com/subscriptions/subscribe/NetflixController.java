package com.subscriptions.subscribe;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class NetflixController {
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello, %s from Netflix!!!";

    @GetMapping("/netflix/{name}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Netflix sayHello(@PathVariable String name){
        return new Netflix(counter.incrementAndGet(), String.format(template,name));
    }
}
