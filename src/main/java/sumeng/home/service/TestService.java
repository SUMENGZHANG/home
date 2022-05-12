package sumeng.home.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sumeng.delay.DelayMessage;
import sumeng.delay.DelayMessageConsumer;

import java.util.concurrent.DelayQueue;


@Service
public class TestService {

    @Autowired
    private DelayMessage delayMessage;
    public String get(){
        DelayQueue<DelayMessage> queue = new DelayQueue<>();
        delayMessage.setScheduleTime(5000);
        queue.add(delayMessage);
        new DelayMessageConsumer(queue).start();
        return "hello";
    }
}
