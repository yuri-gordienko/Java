package ua.com.alevel.service.aop.point;

import org.aspectj.lang.ProceedingJoinPoint;

public interface AspectPointProductInfoSearch {

    void pointcut();
    Object doAspect(ProceedingJoinPoint point) throws Throwable;
}
