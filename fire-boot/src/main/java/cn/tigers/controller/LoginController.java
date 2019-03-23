package cn.tigers.controller;

import cn.tigers.login.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tigershome on 2018/11/17.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/forest")
public class LoginController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = {"/hello", "login"}, method = RequestMethod.GET)
    private String login() {
        return "Login successfully";
    }


    /**
     * http://localhost:8080/forest/getUserById?userId=jack
     * http://localhost:8080/forest/getUserById/jack
     * @param userId
     * @return
     */
    //
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    private String getUserById(@RequestParam(value = "userId", required = true) String userId) {
        if(userId == null) {
            return "Please give your userId";
        }

        return messageService.getMessage();
    }
}
