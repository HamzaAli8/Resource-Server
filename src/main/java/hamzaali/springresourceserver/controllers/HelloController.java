package hamzaali.springresourceserver.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {


    @GetMapping(value = "/public")
    public String publicHello(){

        return "Hi there";

    }


    @GetMapping(value = "/private")
    public String privateHello(){

        return "Welcome to the dark side";

    }



}
