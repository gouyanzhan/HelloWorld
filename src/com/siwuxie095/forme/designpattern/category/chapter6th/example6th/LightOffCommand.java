package com.siwuxie095.forme.designpattern.category.chapter6th.example6th;

/**
 * 关灯的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 17:48:09
 */
class LightOffCommand implements Command {

    /**
     * 持有对灯的引用
     */
    private Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    /**
     * 执行命令：关灯
     */
    @Override
    public void execute() {
        light.off();
    }
}
