package com.training.system.assessment;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @GetMapping("/status/{userId}")
    public Map<String, Object> getAssessmentStatus(@PathVariable String userId) {
        return Map.of(
                "userId", userId,
                "assessmentStatus", "READY",
                "examName", "Final Assessment",
                "score", 0
        );
    }

    @PostMapping("/complete/{userId}/{courseId}")
    public Map<String, Object> completeAssessment(
            @PathVariable String userId,
            @PathVariable String courseId
    ) {
        return Map.of(
                "userId", userId,
                "courseId", courseId,
                "assessmentPassed", true,
                "score", 90,
                "event", "CourseCompleted"
        );
    }
}