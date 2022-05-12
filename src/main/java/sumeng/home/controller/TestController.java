package sumeng.home.controller;


import sumeng.delay.DelayMessage;
import sumeng.delay.DelayMessageConsumer;
import sumeng.log.MyLog;
import sumeng.log.beans.ReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sumeng.home.service.TestService;

import java.util.concurrent.DelayQueue;

@RestController
@RequestMapping("/aop")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(path = "/test", method = RequestMethod.POST)
    public String test(@RequestBody ReqDTO reqDTO) {
        String res = testService.get();
        return res+" success";

    }

}
