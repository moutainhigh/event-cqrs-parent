package com.hack.core.async;

import com.hack.core.aspectj.LmaxAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AsyncComponent {

    @LmaxAsync
    public void slowCall() {
        System.out.println("slow call start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("slow call end");
    }
}
