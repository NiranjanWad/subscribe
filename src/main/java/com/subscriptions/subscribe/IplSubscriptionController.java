package com.subscriptions.subscribe;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class IplSubscriptionController {

    private final AtomicLong counter = new AtomicLong();
    private static final String message = "Hello, %s from IPL";

    @GetMapping("/ipl/{name}")
    @CrossOrigin(origins = "http://localhost:4200")
    public IplSubscription sayHello(@PathVariable String name){
        return new IplSubscription(counter.incrementAndGet(),String.format(message,name));
    }
}
