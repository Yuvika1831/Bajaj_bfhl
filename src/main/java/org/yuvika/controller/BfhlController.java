package org.yuvika.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yuvika.dto.BfhlRequest;
import org.yuvika.dto.BfhlResponse;
import org.yuvika.service.BfhlService;

@RestController
public class BfhlController {

    private final BfhlService service;

    public BfhlController(BfhlService service) {
        this.service = service;
    }

    @GetMapping("/bfhl")
    public ResponseEntity<String> getBfhl() {
        return ResponseEntity.ok("BFHL API is running");
    }

    @PostMapping("/bfhl")
    public ResponseEntity<BfhlResponse> process(
            @RequestBody BfhlRequest request) {

        return ResponseEntity.ok(
                service.process(request)
        );
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
