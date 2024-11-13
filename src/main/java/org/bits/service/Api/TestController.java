package org.bits.service.Api;

import org.bits.service.Domain.Response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok(new ApiResponse(true, "test successful", "hello test").toString());
    }
}