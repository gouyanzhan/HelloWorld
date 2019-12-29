package com.siwuxie095.forme.designpattern.category.chapter6th.example6th;

/**
 * 开洒水器的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 18:23:57
 */
class SprinklerOnCommand implements Command {

    /**
     * 持有对洒水器的引用
     */
    private Sprinkler sprinkler;

    SprinklerOnCommand(Sprinkler sprinkler) {
        this.sprinkler = sprinkler;
    }

    /**
     * 执行命令：打开洒水器的水源
     */
    @Override
    public void execute() {
        sprinkler.waterOn();
    }
}
