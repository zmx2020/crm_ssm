package net.wanho.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * Created by Administrator on 2019/4/11.
 */
@Aspect
@Component
public class LogAspect {

    private Logger logger=Logger.getLogger(LogAspect.class);
    @Around(value = "execution(* net.wanho.service..*.*(..))")
    public Object logPrinter(ProceedingJoinPoint joinPoint){
        Object result=null;
        logger.error("前置通知：");
        logger.error("调用方法："+joinPoint.getSignature().getName()
                +"方法中参数"+ Arrays.toString(joinPoint.getArgs()));
        try {
            result= joinPoint.proceed();
            logger.error("返回通知：结果："+result);
            return result;
        } catch (Throwable throwable) {
            logger.error("异常通知：异常："+throwable);
            throwable.printStackTrace();
        }
        logger.error("后置通知：方法执行完毕！");
        return result;
    }
}
