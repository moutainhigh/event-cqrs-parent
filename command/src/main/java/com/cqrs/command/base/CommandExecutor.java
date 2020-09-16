package com.cqrs.command.base;

/**
 * 暂时用来做标识
 */
public interface CommandExecutor<In extends BaseCommand, Out > {

    /**
     * 用来如何执行
     * @param command
     * @return
     */
     Out execute(In command);


     boolean match(Object object);

}
