package application.controller;


import application.config.jwt.JwtProvider;
import application.entity.UserEntity;
import application.repository.UserEntityRepository;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserEntityRepository userEntityRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        UserEntity userEntity = userService.findByLoginAndPassword(registrationRequest.getLogin(), registrationRequest.getPassword());

        if (userEntity == null) {
            u.setName(registrationRequest.getName());
            u.setSecond_name(registrationRequest.getSecond_name());
            u.setPassword(registrationRequest.getPassword());
            u.setLogin(registrationRequest.getLogin());
            userService.saveUser(u);
            return "Зрегистрирован";
        } else return "Пользователь с такими данными уже существует";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        AuthResponse authResponse = new AuthResponse();

        if (userEntity != null) {
            String token = jwtProvider.generateToken(userEntity.getLogin());
            authResponse.setToken(token);
            authResponse.setName(userEntity.getName());
            authResponse.setSecond_name(userEntity.getSecond_name());
        } else {
            authResponse.setName("Пользователь не найден");
        }
        return authResponse;
    }


}