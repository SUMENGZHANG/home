package sumeng.home.controller;

import log.annotation.MyLog;
import log.beans.ReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sumeng.home.service.TestService;

@RestController
@EnableAspectJAutoProxy(exposeProxy = true)
@RequestMapping("/aop")
public class TestController {

    @Autowired
    private TestService testService;
    @RequestMapping(path = "/test", method = RequestMethod.POST)
    public String test(@RequestBody ReqDTO reqDTO) {
        int i = 1;   //模拟异常
        System.out.println("调用 Log测试 方法");
        return testService.get();
    }

}
