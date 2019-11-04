package com.siwuxie095.forme.designpattern.category.chapter6th.example6th;

/**
 * 开吊扇的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 17:50:27
 */
class CeilingFanOnCommand implements Command {

    /**
     * 持有对吊扇的引用
     */
    private CeilingFan ceilingFan;

    CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /**
     * 执行命令：开吊扇，并将吊扇设为高速
     */
    @Override
    public void execute() {
        ceilingFan.high();
    }
}
