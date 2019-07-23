package net.psoap;

import net.psoap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    //TODO
    @GetMapping(path = "/")
    public String hello(){
        return "<h1>hello</h1>";
    }
}