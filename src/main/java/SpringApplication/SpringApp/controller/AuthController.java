package SpringApplication.SpringApp.controller;

import SpringApplication.SpringApp.dto.AuthRequestDto;
import SpringApplication.SpringApp.dto.AuthResponseDto;
import SpringApplication.SpringApp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponseDto register(@RequestBody AuthRequestDto requestDto){
        return authService.register(requestDto);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto requestDto){
        return authService.login(requestDto);
    }
}
