package sumeng.log.annotation;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import sumeng.log.MyLog;

@Aspect
@Component
public class LogAspect {

    private Logger logger= LoggerFactory.getLogger(LogAspect.class);
    @Pointcut(value = "@annotation(sumeng.log.MyLog)")
    public void myPointCut(){

    }

    @Around("@annotation(myLog)")
    public Object around(ProceedingJoinPoint jp, MyLog myLog) throws Throwable {
        System.out.println("start....");
        String className = jp.getTarget().getClass().toString();
        String methodName = jp.getSignature().getName();
        Object[] arr = jp.getArgs();
        logger.info("参数"+ JSON.toJSONString(arr));
        Object obj = jp.proceed();
        logger.info("调用后"+ JSON.toJSONString(obj));
        return obj;

    }
}
