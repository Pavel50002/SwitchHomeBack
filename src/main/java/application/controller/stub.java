package application.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;


@RestController
//    @RequestMapping("/register")
    public class stub {


        @GetMapping(value = "/stubdevice",produces = MediaType.APPLICATION_JSON_VALUE)
        public String stubdevice(){
            String pp = "{\n" +
                    "\"data\":{\n" +
                    "\"devices\":[\n" +
                    "    {\n" +
                    "\"id\":1,\n" +
                    "\"ip\":\"192.168.1.22\",\n" +
                    "\"description\":\"Device in big room\",\n" +
                    "\"room\":\"big\",\n" +
                    "\"how_much_to_work\":3600000,\n" +
                    "\"is_online\":false\n" +
                    "},\n" +
                    "{\n" +
                    "\"id\":2,\n" +
                    "\"ip\":\"192.168.1.25\",\n" +
                    "\"description\":\"Device in kitchen\",\n" +
                    "\"room\":\"kitchen\",\n" +
                    "\"how_much_to_work\":1800000,\n" +
                    "\"is_online\":true\n" +
                    "}\n" +
                    "]\n" +
                    "}\n" +
                    "}";
            return pp;
        }
    }

