package com.training.system.scheduling;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/sessions")
public class SchedulingController {

    @GetMapping("/course/{courseId}")
    public Map<String, Object> getCourseSchedule(
            @PathVariable String courseId
    ) {

        return Map.of(
                "courseId", courseId,
                "sessionDate", "2026-06-01",
                "sessionTime", "10:00 AM",
                "room", "Lab A"
        );
    }

    @PostMapping("/book/{userId}/{courseId}")
    public Map<String, Object> bookSession(
            @PathVariable String userId,
            @PathVariable String courseId
    ) {

        return Map.of(
                "userId", userId,
                "courseId", courseId,
                "bookingStatus", "CONFIRMED"
        );
    }
}