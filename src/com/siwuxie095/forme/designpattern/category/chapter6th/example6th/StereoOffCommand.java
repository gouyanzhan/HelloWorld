package com.siwuxie095.forme.designpattern.category.chapter6th.example6th;

/**
 * 关音响的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 18:32:52
 */
class StereoOffCommand implements Command {

    /**
     * 持有对音响的引用
     */
    private Stereo stereo;

    StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /**
     * 执行命令：关音响
     */
    @Override
    public void execute() {
        stereo.off();
    }
}
