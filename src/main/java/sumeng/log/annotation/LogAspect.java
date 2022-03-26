package sumeng.log.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sumeng.entity.User;
import sumeng.home.mapper.LogMapper;
import sumeng.log.MyLog;
import sumeng.log.beans.OpLog;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogMapper logMapper;
    private Logger logger= LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(sumeng.log.MyLog)")
    public void myPointCut(){

    }

    @AfterReturning(value = "myPointCut()", returning = "response")
    public void saveLog(JoinPoint joinPoint, Object response) throws Throwable {
        System.out.println("start....");
        System.out.println(response.toString());
        System.out.println(joinPoint.getSignature().getName().toString());
        OpLog opLog = new OpLog();
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();

        Method method  = signature.getMethod();
        String methodName = method.getName();
        MyLog myLog = method.getAnnotation(MyLog.class);
        String desc = myLog.desc();
        String params = joinPoint.getArgs().toString();
        opLog.setDesc(desc);
        String className = joinPoint.getTarget().getClass().getName();
        opLog.setMethodName(className+":"+methodName);
        opLog.setParams(params);
        opLog.setResponse(response.toString());
        opLog.setUserName("simon");
        opLog.setInsertTime(new Date());
        boolean res = logMapper.insertUserLog(opLog);
        logger.info("insert res:"+res);


    }
}
