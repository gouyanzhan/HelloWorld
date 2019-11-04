package com.siwuxie095.forme.designpattern.category.chapter6th.example3rd;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-10-28 18:16:04
 */
class Client {

    /**
     * 创建命令
     */
    Command createCommand() {
        return new Command(new Receiver());
    }

}
