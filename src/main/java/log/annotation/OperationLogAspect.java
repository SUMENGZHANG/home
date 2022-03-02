package log.annotation;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.http.HttpServletRequest;
import log.beans.OpLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import sumeng.home.mapper.LogMapper;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;


@Component
@Aspect
public class OperationLogAspect {

    @Autowired
    private LogMapper logMapper;

    @Pointcut("@annotation(log.annotation.OperationLog)")
    public void pointCut(){

    }

    @Pointcut("execution(* sumeng.home.controller..*.*(..))")
    public void exceptionPointCut(){

    }
    @Before("pointCut()")
    public void before(){
        System.out.println("开始执行。。。。。");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("执行结束。。。。");
    }

    @AfterReturning(value = "pointCut()", returning = "keys")
    public void saveOperationLog(JoinPoint joinPoint, Object keys){

        RequestAttributes requestAttributes  = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest)  requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        OpLog opLog = new OpLog();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        OperationLog op = method.getAnnotation(OperationLog.class);
        opLog.setDesc(op.desc());
        opLog.setType(op.operationType());

        String klassName = joinPoint.getTarget().getClass().getName();
        String methodName  = method.getName();
        opLog.setMethodName(klassName+":"+methodName);

        Map<String,String[]> requestMap  = request.getParameterMap();
        String params = JSON.toJSONString(requestMap);
        opLog.setParams(params);
        opLog.setResponse(JSON.toJSONString(keys));

        opLog.setUserName("sumengzhang");

        opLog.setInsertTime(new Date());
        System.out.println(JSON.toJSONString(opLog));
        boolean res = logMapper.insertUserLog(opLog);
        System.out.println(res);





    }




}
