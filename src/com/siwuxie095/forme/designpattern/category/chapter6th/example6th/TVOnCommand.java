package com.siwuxie095.forme.designpattern.category.chapter6th.example6th;

/**
 * 开电视的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 18:34:57
 */
class TVOnCommand implements Command {

    /**
     * 持有对电视的引用
     */
    private TV tv;

    TVOnCommand(TV tv) {
        this.tv = tv;
    }

    /**
     * 执行命令：开电视
     */
    @Override
    public void execute() {
        tv.on();
    }
}
