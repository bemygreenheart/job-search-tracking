package uz.jaxathon.jobsearchtracking.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class EntityDeletionLogger {

    @AfterReturning(value = "execution(* uz.jaxathon.jobsearchtracking.services..delete(..))")
    public void logAfterDelete(JoinPoint joinPoint){
        System.out.println("------ Delete entity -----");
    }
}
