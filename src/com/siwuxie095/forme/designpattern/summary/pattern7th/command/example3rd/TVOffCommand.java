package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example3rd;

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

    /**
     * 撤销命令：开电视
     */
    @Override
    public void undo() {
        tv.on();
    }
}
