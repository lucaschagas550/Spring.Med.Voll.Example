package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Anotacao para Api Rest
@RequestMapping("/hello") //Mapeamento do request para a classe
public class HelloController {

    @GetMapping
    public String olaMundo(){

        return "Hello World";
    }
}
