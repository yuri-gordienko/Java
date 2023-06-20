package ua.com.alevel.service.aop.point;

import org.aspectj.lang.ProceedingJoinPoint;

public interface AspectPointProductInfoSearch {

    void pointcut();    // метод перехвата, описывает что делать в момент перехвата, описываем точку перехвата
    Object doAspect(ProceedingJoinPoint point) throws Throwable; // сам перехватчик, возвращаем Object, т.к. не знаем что перехватываем
    // ProceedingJoinPoint point - джава класс, объект перехвата
    // в методе doAspect описываем, что мы делаем в момент перехвата
}