package com.siwuxie095.forme.designpattern.category.chapter6th.example7th;

/**
 * 开音响并设置成 DVD 模式的命令
 *
 * @author Jiajing Li
 * @date 2019-10-29 18:28:26
 */
class StereoOnWithDVDCommand implements Command {

    /**
     * 持有对音响的引用
     */
    private Stereo stereo;

    StereoOnWithDVDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /**
     * 执行命令：开音响并设置成 DVD 模式，同时设置音量为 20
     */
    @Override
    public void execute() {
        stereo.on();
        stereo.setDvd();
        stereo.setVolume(20);
    }

    /**
     * 撤销命令：关音响
     */
    @Override
    public void undo() {
        stereo.off();
    }
}
