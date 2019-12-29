package com.siwuxie095.forme.designpattern.category.chapter6th.example6th;

/**
 * 关电视的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 18:37:27
 */
public class TVOffCommand implements Command {

    /**
     * 持有对电视的引用
     */
    private TV tv;

    TVOffCommand(TV tv) {
        this.tv = tv;
    }

    /**
     * 执行命令：关电视
     */
    @Override
    public void execute() {
        tv.off();
    }
}
