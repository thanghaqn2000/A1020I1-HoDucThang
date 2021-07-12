package vn.codegym.concern;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import vn.codegym.validation.AmountLessThanZero;

import java.time.LocalDate;
import java.util.Arrays;

@Component

@org.aspectj.lang.annotation.Aspect

public class Aspect {
    @Pointcut("within(vn.codegym.controller.BookController*)")
    public void allMethods() {
    }
    ;
    @Before("allMethods()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name: "+joinPoint.getSignature().getName()+" Time: "+ LocalDate.now());
    }
    @AfterThrowing(pointcut = "within(vn.codegym.controller.BookController*)", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, AmountLessThanZero e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String argsName = Arrays.toString(joinPoint.getArgs());
        System.err.printf("An error has occurred at: %s.%s.%s : %s", className, methodName, argsName, e.getMessage());
    }
}
