package com.cqrs.command.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * command bus 的简单实现
 */
@Component
public class CommandBus {

    @Autowired
    private List<CommandExecutor> executors;

    public <T> T execute(BaseCommand baseCommand, Class<T> result) {
        CommandExecutor executor = findExecutor(baseCommand);
        return (T) executor.execute(baseCommand);

    }

    public CommandExecutor findExecutor(BaseCommand baseCommand) {
        return executors.stream().filter(executor -> executor.match(baseCommand)).findFirst().orElseThrow(() -> new RuntimeException("can not find the executor"));

    }

}
