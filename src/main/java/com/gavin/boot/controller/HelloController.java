package com.gavin.boot.controller;

//import org.springframework.stereotype.Controller;

import com.gavin.boot.bean.Car;
import com.gavin.boot.bean.Person;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @RestController = @ResponseBody + @Controller
 */

//@ResponseBody
//@Controller

@RestController
@Slf4j
public class HelloController {

    @Autowired
    Car car;
    @Autowired
    Person person;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello")
    public String handle01() {
        System.out.println("sout 请求进来了");
        log.info("请求进来了");
        return "Hello, Spring Boot 2!";
    }

    @RequestMapping("/person")
    public Person person() {
        return person;
    }

    @RequestMapping("/gavin.jpg")
    public String hello() {
        //request
        return "gavin.jpg";
    }


    //    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser() {

        return "GET-张三";
    }

    //    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser() {
        return "POST-张三";
    }


    //    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser() {

        return "PUT-张三";
    }

    @DeleteMapping("/user")
    //    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser() {
        return "DELETE-张三";
    }
}
