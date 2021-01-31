package application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/s")
public class TestSecurityController {

    @GetMapping("/admin/get/")
    public String getAdmin() {
        return "Hi admin";
    }

    @GetMapping("/u")
    public String getUser() {
        return "Hi user";
    }
}
