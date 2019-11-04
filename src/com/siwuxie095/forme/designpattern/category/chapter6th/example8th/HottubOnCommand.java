package com.siwuxie095.forme.designpattern.category.chapter6th.example8th;

/**
 * 开热水浴缸的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 18:15:46
 */
class HottubOnCommand implements Command {

    /**
     * 持有对热水浴缸的引用
     */
    private Hottub hottub;

    HottubOnCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    /**
     * 执行命令：打开热水浴缸的喷射器，并将温度设为 50 摄氏度
     */
    @Override
    public void execute() {
        hottub.jetsOn();
        hottub.setTemperature(50);
    }

    /**
     * 撤销命令：关闭热水浴缸的喷射器
     */
    @Override
    public void undo() {
        hottub.jetsOff();
    }
}
