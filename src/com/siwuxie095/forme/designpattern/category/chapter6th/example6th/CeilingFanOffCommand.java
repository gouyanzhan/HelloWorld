package com.siwuxie095.forme.designpattern.category.chapter6th.example6th;

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

    CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /**
     * 执行命令：关风扇
     */
    @Override
    public void execute() {
        ceilingFan.off();
    }
}
