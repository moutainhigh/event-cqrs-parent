package com.hack.core.demo;

import com.hack.core.aspectj.Lighting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoComponent {

    @Lighting
    public void lingtNingCall() {
        log.info("lingtning call start");

    }
}
