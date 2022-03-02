package sumeng.home.service;

import log.annotation.MyLog;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

@Service
@EnableAspectJAutoProxy(exposeProxy = true)
public class TestService {
    @MyLog(operateType = "Log测试:", operateExplain = "模拟日志记录")  //这里使用的自定义注解
    public String get(){
        return "hello";
    }
}
