package sumeng.home.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import sumeng.entity.User;
import sumeng.home.mapper.LogMapper;
import sumeng.home.mapper.UserMapper;
import sumeng.log.MyLog;


@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LogMapper logMapper;

    @GetMapping("/hello")
    @MyLog
    public String index(){
        System.out.println("index...");
        return "hello index";
    }

    @PostMapping(path = "/user")
    @MyLog
    public String getUserById(@RequestBody User user){
         return "save user log";
    }

    @GetMapping("/hello2")
    @MyLog
    public String hello2() {

        return "hello2";
    }


}
