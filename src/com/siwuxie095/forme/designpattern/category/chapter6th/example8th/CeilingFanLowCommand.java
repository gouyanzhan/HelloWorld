package com.siwuxie095.forme.designpattern.category.chapter6th.example8th;

/**
 * 开吊扇并设为低速的命令
 *
 * @author Jiajing Li
 * @date 2019-11-04 11:31:05
 */
class CeilingFanLowCommand implements Command {

    /**
     * 持有对吊扇的引用
     */
    private CeilingFan ceilingFan;

    /**
     * 前一个速度
     */
    private int prevSpeed;

    CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /**
     * 执行命令：开吊扇，并将吊扇设为低速
     */
    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
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
