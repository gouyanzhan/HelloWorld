package com.siwuxie095.forme.designpattern.category.chapter6th.example6th;

/**
 * 开车库门的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 18:09:47
 */
class GarageDoorOpenCommand implements Command {

    /**
     * 持有对车库门的引用
     */
    private GarageDoor garageDoor;

    GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    /**
     * 执行命令：车库门上升并开灯
     */
    @Override
    public void execute() {
        garageDoor.up();
        garageDoor.lightOn();
    }
}
