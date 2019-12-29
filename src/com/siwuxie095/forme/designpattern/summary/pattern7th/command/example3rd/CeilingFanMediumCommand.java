package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example3rd;

/**
 * 开吊扇并设为中速的命令
 *
 * @author Jiajing Li
 * @date 2019-11-04 11:29:01
 */
class CeilingFanMediumCommand implements Command {

    /**
     * 持有对吊扇的引用
     */
    private CeilingFan ceilingFan;

    /**
     * 前一个速度
     */
    private int prevSpeed;

    CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /**
     * 执行命令：开吊扇，并将吊扇设为中速
     */
    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
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
