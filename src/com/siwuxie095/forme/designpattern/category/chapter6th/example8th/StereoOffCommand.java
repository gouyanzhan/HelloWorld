package com.siwuxie095.forme.designpattern.category.chapter6th.example8th;

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

    /**
     * 撤销命令：开音响并设置成 DVD 模式，同时设置音量为 20
     */
    @Override
    public void undo() {
        stereo.on();
        stereo.setDvd();
        stereo.setVolume(20);
    }
}
