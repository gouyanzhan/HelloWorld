package com.siwuxie095.forme.designpattern.category.chapter6th.example5th;

/**
 * 开灯的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 17:03:34
 */
class LightOnCommand implements Command {

    /**
     * 持有对灯的引用
     */
    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        light.on();
    }
}
