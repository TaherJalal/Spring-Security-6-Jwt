package SpringApplication.SpringApp.service;

import SpringApplication.SpringApp.dto.AuthRequestDto;
import SpringApplication.SpringApp.dto.AuthResponseDto;
import SpringApplication.SpringApp.model.Role;
import SpringApplication.SpringApp.model.User;
import SpringApplication.SpringApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDto register(AuthRequestDto requestDto) {
        var user = User.builder()
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponseDto.builder().token(jwtService.generateToken(user.getEmail())).build();
    }

    public AuthResponseDto login(AuthRequestDto requestDto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getEmail(),requestDto.getPassword()));
        var user = userRepository.findByEmail(requestDto.getEmail());
        return  AuthResponseDto.builder().token(jwtService.generateToken(user.get().getEmail())).build();
    }
}
