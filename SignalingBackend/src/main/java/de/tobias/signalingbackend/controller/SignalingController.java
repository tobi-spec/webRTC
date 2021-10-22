package de.tobias.signalingbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class SignalingController {

    @GetMapping("/conncetion")
    public ResponseEntity<String> connection(){
        return ok("Server is running");
    }
}
