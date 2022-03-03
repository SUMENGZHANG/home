package sumeng.home.service;


import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

@Service

public class TestService {
    public String get(){
        return "hello";
    }
}
