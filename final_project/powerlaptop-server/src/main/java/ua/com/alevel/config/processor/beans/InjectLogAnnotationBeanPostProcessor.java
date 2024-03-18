package ua.com.alevel.config.processor.beans;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ua.com.alevel.config.processor.annotations.InjectLog;

import java.lang.reflect.Field;

@Component
public class InjectLogAnnotationBeanPostProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public InjectLogAnnotationBeanPostProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();

        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectLog.class)) {
                Object logger = applicationContext.getBean("loggerService");
                field.setAccessible(true);
                try {
                    field.set(bean, logger);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
