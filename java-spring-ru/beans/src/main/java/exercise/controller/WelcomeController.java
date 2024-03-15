package exercise.controller;

import org.springframework.web.bind.annotation.RestController;
import exercise.daytime.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


// BEGIN
@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @Autowired
    private Daytime my_bean;

    @GetMapping("")
    public String getMethodName() {
        return my_bean.toString();
    }

}
// END
