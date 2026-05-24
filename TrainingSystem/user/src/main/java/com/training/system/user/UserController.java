package com.training.system.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}/validate")
    public Map<String, Object> validateUser(@PathVariable String id){
    Map<String, Object> response = new HashMap<>();
    if(id.equals("220223260")){
        response.put("valid", true);
        response.put("name", "Ahlam Abu Diab");
        response.put("userId", id);
    } else {
        response.put("valid", false);
        response.put("name", "Unknown");
        response.put("userId", id);
    }

    return response;
}
}