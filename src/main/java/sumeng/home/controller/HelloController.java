package sumeng.home.controller;


import com.alibaba.fastjson.JSON;
import com.mysql.cj.log.Log;
import log.annotation.Lock;
import log.annotation.MyLog;
import log.annotation.OperationLog;
import log.beans.OpLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;
import sumeng.entity.User;
import sumeng.home.mapper.LogMapper;
import sumeng.home.mapper.UserMapper;

import java.util.Date;

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LogMapper logMapper;


    @GetMapping("/hello")
    @OperationLog(desc = "index",operationType = "get")
    @MyLog(operateExplain = "123",operateType = "232")
    public String index(){
        System.out.println("index...");
        return "hello sumeng";
    }

    @PostMapping(path = "/user")
    @OperationLog(desc = "通过id查找用户", operationType = "query")
    public User getUserById(@RequestBody User user){
         return userMapper.selectUserById(user.getId());
    }

    @GetMapping("/hello2")
    @Lock
    public String hello2() {
        return "hello2";
    }


}
