package sumeng.home.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sumeng.entity.User;
import sumeng.home.mapper.UserMapper;

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/hello")
    public String index(){
        return "hello sumeng";
    }

    @PostMapping(path = "/user")
    public User getUserById(@RequestBody User user){
         return userMapper.selectUserById(user.getId());
    }
}
