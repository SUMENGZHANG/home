package log.annotation;


import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface MyLog {
    /** 操作类型 **/
    String operateType();
    /** 操作解释 **/
    String operateExplain();
}
