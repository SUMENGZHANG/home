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
    public User getUserById(@RequestBody User user){
         return userMapper.selectUserById(user.getId());
    }

    @GetMapping("/hello2")
    public String hello2() {

        return "hello2";
    }


}
