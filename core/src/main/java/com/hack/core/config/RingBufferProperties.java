package com.hack.core.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RingBufferProperties {

    private int bufferSize;

    private int handlerSize;
}
