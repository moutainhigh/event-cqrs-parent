package com.hack.core.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataFlowEvent<T> {

    private long sequence;
    private T data;

    @JsonIgnore
    private Consumer<T> onCompleted;

    @JsonIgnore
    private BiConsumer<T, Throwable> onError;

    @JsonIgnore
    private Consumer<T> subscribe;

    void execute(){
        Optional.ofNullable(subscribe).ifPresent(tConsumer -> {
            try {
                tConsumer.accept(data);
                Optional.ofNullable(onCompleted).ifPresent(com->com.accept(data));
            } catch (Exception e) {
               Optional.ofNullable(onError).ifPresent(err->{
                   err.accept(data,e);
               });
            }
        });
    }


}
