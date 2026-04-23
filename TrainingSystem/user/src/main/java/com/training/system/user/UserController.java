package com.training.system.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}/validate")
    public ResponseEntity<Map<String, Object>> validateUser(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();

        if ("123".equals(id) || "200".equals(id)) {
            response.put("userId", id);
            response.put("valid", true);
            response.put("name", "Ahlam Abu Diab");
        } else {
            response.put("userId", id);
            response.put("valid", false);
            response.put("name", "Unknown");
        }

        return ResponseEntity.ok(response);
    }
}