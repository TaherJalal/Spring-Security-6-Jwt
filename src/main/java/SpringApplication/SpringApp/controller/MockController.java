package SpringApplication.SpringApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mock")
public class MockController {
    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("protected endpoint");
    }
}
