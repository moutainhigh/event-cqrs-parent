package com.hack.core.aspectj;

import com.hack.core.config.RingBufferWrapper;
import com.hack.core.event.DataFlowEvent;
import com.hack.core.event.EventMultiCaster;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Aspect
@Slf4j
public class LmaxAspectj implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Around("@annotation(lmaxAsync)")
    public Object aroundLmaxAsync(ProceedingJoinPoint proceedingJoinPoint, LmaxAsync lmaxAsync) throws Throwable {

        RingBufferWrapper<DataFlowEvent<ProceedingJoinPoint>> ringBufferWrapper = applicationContext.getBean(RingBufferWrapper.class);
        EventMultiCaster multiCaster = applicationContext.getBean(EventMultiCaster.class);
        multiCaster.asyncMulticastFlowEvent(DataFlowEvent.<ProceedingJoinPoint>builder()
                .data(proceedingJoinPoint)
                .subscribe(pjp -> {
                    try {
                        pjp.proceed();
                    } catch (Throwable throwable) {
                        throw new RuntimeException(throwable);
                    }
                }).onCompleted(pjp->{
                    log.info("aspect complete");
                }).onError((pjp,e)->{
                    log.error("on error ",e);
                })
                .build());
        return null;
    }
}
