package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example3rd;

/**
 * 开灯的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 17:47:14
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
     * 执行命令：开灯
     */
    @Override
    public void execute() {
        light.on();
    }

    /**
     * 撤销命令：关灯
     */
    @Override
    public void undo() {
        light.off();
    }
}
