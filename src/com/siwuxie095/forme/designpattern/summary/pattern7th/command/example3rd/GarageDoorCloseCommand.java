package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example3rd;

/**
 * 关车库门的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 18:12:39
 */
class GarageDoorCloseCommand implements Command {

    /**
     * 持有对车库门的引用
     */
    private GarageDoor garageDoor;

    GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    /**
     * 执行命令：车库门下降并关灯
     */
    @Override
    public void execute() {
        garageDoor.down();
        garageDoor.lightOff();
    }

    /**
     * 撤销命令：车库门上升并开灯
     */
    @Override
    public void undo() {
        garageDoor.up();
        garageDoor.lightOn();
    }
}
