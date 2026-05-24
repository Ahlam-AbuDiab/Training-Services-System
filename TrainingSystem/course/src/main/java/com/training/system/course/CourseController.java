package com.training.system.course;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @GetMapping("/{courseId}/availability")
    public Map<String, Object> checkAvailability(@PathVariable String courseId) {
        return Map.of(
                "courseId", courseId,
                "available", true,
                "capacity", 30,
                "registered", 15
        );
    }

    @GetMapping("/{courseId}/details")
    public Map<String, Object> getDetails(@PathVariable String courseId) {
        return Map.of(
                "courseId", courseId,
                "courseName", "Advanced Software Engineering",
                "hours", 3,
                "trainerName", "Dr. Abdelkareem Alashqar"
        );
    }
}