package com.jojoldu.book.web;

import com.jojoldu.book.web.dto.HelloRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "소희는 짱짱 귀여워";
    }

    @GetMapping("/hello/dto")
    public HelloRequestDto helloDto(@RequestParam(name = "name") String name,
                                    @RequestParam(name = "amount") int amount){

        return new HelloRequestDto(name,amount);
    }
}
