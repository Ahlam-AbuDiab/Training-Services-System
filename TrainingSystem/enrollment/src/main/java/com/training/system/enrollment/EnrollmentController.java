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

    @PostMapping("/register/{userId}/{courseId}")
    public ResponseEntity<Map<String, Object>> register(
        @PathVariable String userId,
        @PathVariable String courseId) {

    String userUrl =
            "http://localhost:8081/api/users/" + userId + "/validate";

    String courseUrl =
            "http://localhost:8083/api/courses/" + courseId + "/availability";

    Map userResponse =
            restTemplate.getForObject(userUrl, Map.class);

    Map courseResponse =
            restTemplate.getForObject(courseUrl, Map.class);

    Map<String, Object> response = new HashMap<>();

    boolean validUser =
            userResponse != null &&
            Boolean.TRUE.equals(userResponse.get("valid"));

    boolean availableCourse =
            courseResponse != null &&
            Boolean.TRUE.equals(courseResponse.get("available"));

    if(validUser && availableCourse){

        response.put("message", "Enrollment successful");
        response.put("userId", userId);
        response.put("courseId", courseId);
        response.put("status", "SUCCESS");

    } else {

        response.put("message", "Enrollment failed");
        response.put("status", "FAILED");
    }

    return ResponseEntity.ok(response);
}