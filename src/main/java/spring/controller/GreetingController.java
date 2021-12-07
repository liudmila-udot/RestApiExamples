package spring.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import common.model.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s from Spring!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping(path = "/greeting", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> greeting(@RequestBody Greeting greeting) {
        System.out.println(greeting);
        return ResponseEntity.ok("Test post method Spring");
    }
}
