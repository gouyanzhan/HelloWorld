package com.siwuxie095.forme.designpattern.category.chapter6th.example6th;

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
}
