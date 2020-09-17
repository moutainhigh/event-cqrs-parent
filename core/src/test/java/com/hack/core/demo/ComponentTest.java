package com.hack.core.demo;

import com.hack.core.AbstractTest;
import com.hack.core.event.DataFlowEvent;
import com.hack.core.event.EventMultiCaster;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.IntStream;

@Slf4j
public class ComponentTest extends AbstractTest {
    @Autowired
    private DemoComponent demoComponent;

    @Autowired
    private EventMultiCaster eventMultiCaster;

    @Test
    public void annotaionTest() throws Exception {
        IntStream.range(0, 3).forEach(i -> {
            demoComponent.lingtNingCall();
        });
        log.info("main thread end");
        // wait for handler  to handle
        Thread.sleep(10000);
    }

    @Test
    public void flowTest() throws Exception{
        Arrays.asList(new Pojo("1"), new Pojo("2"), new Pojo("3")).stream().forEach(pojo -> {
            eventMultiCaster.publishSingle(DataFlowEvent.<Pojo>builder()
                    .data(pojo)
                    .subscribe((event -> {
                        log.info("start ================:{}", event);
                    }))
                    .onCompleted((event) -> {
                        log.info("on complete================:{}", event);
                    })
                    .onError((event, e) -> {
                        log.error("on error=============", e);
                    })
                    .build());
        });
        Thread.sleep(10000);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pojo {
        private String name;
    }
}
