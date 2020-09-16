package com.hack.core.async;

import com.hack.core.AbstractTest;
import com.hack.core.event.DataFlowEvent;
import com.hack.core.event.EventMultiCaster;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

@Slf4j
public class AsyncComponentTest extends AbstractTest {
    @Autowired
    private AsyncComponent asyncComponent;

    @Autowired
    private EventMultiCaster eventMultiCaster;

    @Test
    public void slowTest()throws Exception{
        IntStream.range(0,3).forEach(i->{
            asyncComponent.slowCall();
        });
        System.out.println("end==============");
        Thread.sleep(10000);
    }

    @Test
    public void flowTest(){
//        eventMultiCaster.asyncMulticastFlowEvent(DataFlowEvent.<Pojo>bulder.build());
    }


    @Data
    public static class Pojo{
        private String name;
    }
}
