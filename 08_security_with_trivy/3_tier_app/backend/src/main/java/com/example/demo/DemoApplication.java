package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import jakarta.persistence.*;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@Entity
class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    public Message() {}
    public Message(String text) { this.text = text; }
    public Long getId() { return id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}

interface MessageRepository extends org.springframework.data.jpa.repository.JpaRepository<Message, Long> {}

@RestController
@RequestMapping("/api/messages")
class MessageController {
    @Autowired
    private MessageRepository repo;

    @GetMapping
    public List<Message> getAll() { return repo.findAll(); }

    @PostMapping
    public Message add(@RequestBody Message msg) { return repo.save(msg); }
}
