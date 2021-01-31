package application.controller;



import application.config.jwt.JwtProvider;
import application.entity.UserEntity;
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

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        UserEntity userEntity = userService.findByLoginAndPassword(registrationRequest.getLogin(), registrationRequest.getPassword());

       if(userEntity==null){
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);
        return "Зрегистрирован";}
       else return "Пользователь с такими данными уже существует";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());

        if (userEntity != null) {
            String token = jwtProvider.generateToken(userEntity.getLogin());
            return new AuthResponse(token); }
        else return new  AuthResponse("Пользователь не найден");

    }
}