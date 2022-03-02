package log.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {
    @Around("@annotation(myLock)")
    public Object around(ProceedingJoinPoint pjp, Lock myLock) {
        //获取注解里的值
        System.out.println("in around");
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
