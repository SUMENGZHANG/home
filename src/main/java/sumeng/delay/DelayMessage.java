package sumeng.delay;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import sumeng.home.mapper.LogMapper;
import sumeng.log.beans.OpLog;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Component
public class DelayMessage implements Delayed {



    protected   long scheduleTime;

    @Autowired
    private LogMapper logMapper;

    public static DelayMessage delayMessage;

    @PostConstruct
    public void init(){
        delayMessage = this;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long expireTime = scheduleTime-System.currentTimeMillis();
        return unit.convert(expireTime,TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.scheduleTime-((DelayMessage) o).scheduleTime);
    }

    public long getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(long scheduleTime) {
        this.scheduleTime = System.currentTimeMillis()+scheduleTime;
    }

    public void execute(){

        OpLog opLog = new OpLog();
        opLog.setMethodName("1");
        opLog.setDesc("1");
        opLog.setParams("1");
        opLog.setUserName("sumengzhang");
        opLog.setInsert_time(new Date());
        opLog.setType("1");
        opLog.setResponse("1");
        opLog.setInsertTime(new Date());
        delayMessage.logMapper.insertUserLog(opLog);
    }
}
