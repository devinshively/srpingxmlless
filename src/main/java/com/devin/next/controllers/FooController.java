package com.devin.next.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dshively
 * Created On: 9/15/14 2:23 PM
 */
@Controller
public class FooController {

    @RequestMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("wisdom", "Goodbye :) XML");

        return "hello"; // renders /WEB-INF/views/hello.jsp
    }

}
