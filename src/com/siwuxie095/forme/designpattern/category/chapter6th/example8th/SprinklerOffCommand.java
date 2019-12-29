package com.siwuxie095.forme.designpattern.category.chapter6th.example8th;

/**
 * 关洒水器的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 18:26:07
 */
public class SprinklerOffCommand implements Command {

    /**
     * 持有对洒水器的引用
     */
    private Sprinkler sprinkler;

    SprinklerOffCommand(Sprinkler sprinkler) {
        this.sprinkler = sprinkler;
    }

    /**
     * 执行命令：关闭洒水器的水源
     */
    @Override
    public void execute() {
        sprinkler.waterOff();
    }

    /**
     * 撤销命令：打开洒水器的水源
     */
    @Override
    public void undo() {
        sprinkler.waterOn();
    }
}
