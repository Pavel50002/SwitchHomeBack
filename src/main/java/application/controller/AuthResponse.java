package application.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class AuthResponse {
    private String token;
    private String name;
    private String second_name;

    public AuthResponse() {

    }
}
