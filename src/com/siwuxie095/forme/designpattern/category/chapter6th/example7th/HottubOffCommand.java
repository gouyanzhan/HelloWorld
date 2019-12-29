package com.siwuxie095.forme.designpattern.category.chapter6th.example7th;

/**
 * 关热水浴缸的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 18:19:58
 */
class HottubOffCommand implements Command {

    /**
     * 持有对热水浴缸的引用
     */
    private Hottub hottub;

    HottubOffCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    /**
     * 执行命令：关闭热水浴缸的喷射器
     */
    @Override
    public void execute() {
        hottub.jetsOff();
    }

    /**
     * 撤销命令：打开热水浴缸的喷射器，并将温度设为 50 摄氏度
     */
    @Override
    public void undo() {
        hottub.jetsOn();
        hottub.setTemperature(50);
    }
}
