package com.training.system.enrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/register/{userId}")
    public ResponseEntity<Map<String, Object>> register(@PathVariable String userId) {

        String url = "http://localhost:8081/api/users/" + userId + "/validate";

        Map userResponse = restTemplate.getForObject(url, Map.class);

        Map<String, Object> response = new HashMap<>();

        if (userResponse != null && Boolean.TRUE.equals(userResponse.get("valid"))) {
            response.put("message", "Enrollment successful");
            response.put("userId", userId);
            response.put("status", "SUCCESS");
        } else {
            response.put("message", "Enrollment failed: invalid user");
            response.put("userId", userId);
            response.put("status", "FAILED");
        }

        return ResponseEntity.ok(response);
    }
}