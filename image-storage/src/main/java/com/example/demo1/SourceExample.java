package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableBinding(Source.class)
@RestController
@RequestMapping("/eventhub")
public class SourceExample {

    @Autowired
    private Source source;

    @PostMapping("/messages")
    public String postMessage(@RequestBody String message) {
        this.source.output().send(new GenericMessage<>(message));
        return message;
    }
}
