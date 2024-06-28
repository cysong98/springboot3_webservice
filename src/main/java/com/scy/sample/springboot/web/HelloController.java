package com.scy.sample.springboot.web;

import com.scy.sample.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "HELLO!!";
    }


    @GetMapping("/hello/dto")
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        // @RequestParam : 외부에서 API로 넘긴 파라미터를 받아옴
        return new HelloResponseDto(name, amount);
    }
}
