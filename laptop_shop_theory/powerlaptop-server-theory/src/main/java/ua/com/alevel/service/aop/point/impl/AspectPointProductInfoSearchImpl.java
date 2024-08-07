package ua.com.alevel.service.aop.point.impl;

import org.apache.commons.lang3.ArrayUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

import ua.com.alevel.service.aop.point.AspectPointProductInfoSearch;
import ua.com.alevel.service.aop.process.ProductInfoSearchProcessService;

@Aspect // объясняем, что это аспект класс (перехватчик)
@Component // Бин класс
public class AspectPointProductInfoSearchImpl implements AspectPointProductInfoSearch {

    private final ProductInfoSearchProcessService productInfoSearchProcessService;

    public AspectPointProductInfoSearchImpl(ProductInfoSearchProcessService productInfoSearchProcessService) {
        this.productInfoSearchProcessService = productInfoSearchProcessService;
    }

    @Override   // указываем что это метод поинткат, перехватыват все что лежит в пакете ua.com.alevel.....
    @Pointcut("execution(* ua.com.alevel.service.crud.product.ProductInfoSearchService.search(..))")
    public void pointcut() { }  // описали сам перехват

    @Override
    @Around(value = "pointcut()")   // тип перехвата Around и указываем метод перехвата pointcut()
    public Object doAspect(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        if (ArrayUtils.isNotEmpty(args)) {
            String query = (String) args[0];
            productInfoSearchProcessService.saveSearchQuery(query);
        }
        return point.proceed(); // если перехватываем задача вернуть корректную информацию
    }
}