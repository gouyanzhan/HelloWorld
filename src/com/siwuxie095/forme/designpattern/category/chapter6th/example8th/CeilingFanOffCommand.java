package com.siwuxie095.forme.designpattern.category.chapter6th.example8th;

/**
 * 关风扇的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 18:03:39
 */
class CeilingFanOffCommand implements Command {

    /**
     * 持有对吊扇的引用
     */
    private CeilingFan ceilingFan;

    /**
     * 前一个速度
     */
    private int prevSpeed;

    CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /**
     * 执行命令：关风扇
     */
    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    /**
     * 撤销命令：根据 prevSpeed 撤销
     */
    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
