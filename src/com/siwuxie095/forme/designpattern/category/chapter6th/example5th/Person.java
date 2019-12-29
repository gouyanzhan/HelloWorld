package com.siwuxie095.forme.designpattern.category.chapter6th.example5th;

/**
 * 人（客户）
 *
 * @author Jiajing Li
 * @date 2019-10-27:10:53
 */
class Person {

    /**
     * 创建开灯的命令，默认指定好接收者是灯
     */
    Command createLightOnCommand() {
        return new LightOnCommand(new Light());
    }

}
