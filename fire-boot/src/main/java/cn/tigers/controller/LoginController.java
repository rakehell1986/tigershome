package cn.tigers.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tigershome on 2018/11/17.
 */
@RestController
@EnableAutoConfiguration
public class LoginController {

    @RequestMapping("/hello")
    private String login() {
        return "Login successfully";
    }
}
