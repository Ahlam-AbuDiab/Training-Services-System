package com.training.system.certification;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/certificates")
public class CertificationController {

    @GetMapping("/status/{userId}")
    public Map<String, Object> certificateStatus(@PathVariable String userId) {

        return Map.of(
                "userId", userId,
                "certificateAvailable", true,
                "certificateName", "Spring Boot Certificate"
        );
    }

    @PostMapping("/issue/{userId}/{courseId}")
    public Map<String, Object> issueCertificate(
            @PathVariable String userId,
            @PathVariable String courseId
    ) {

        return Map.of(
                "userId", userId,
                "courseId", courseId,
                "status", "ISSUED",
                "certificateId", "CERT-2026-001"
        );
    }
}