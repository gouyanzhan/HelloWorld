package com.siwuxie095.forme.designpattern.category.chapter7th.example6th;

/**
 * 家庭影院外观
 *
 * @author Jiajing Li
 * @date 2019-11-04 22:17:18
 */
class HomeTheaterFacade {

    /**
     * 组合：会用到的子系统组件全部都在这里
     */
    private Amplifier amplifier;

    private CdPlayer cdPlayer;

    private DvdPlayer dvdPlayer;

    private PopcornPopper popcornPopper;

    private Projector projector;

    private Screen screen;

    private TheaterLight theaterLight;

    private Tuner tuner;

    public HomeTheaterFacade(Amplifier amplifier,
                             CdPlayer cdPlayer,
                             DvdPlayer dvdPlayer,
                             PopcornPopper popcornPopper,
                             Projector projector,
                             Screen screen,
                             TheaterLight theaterLight,
                             Tuner tuner) {
        this.amplifier = amplifier;
        this.cdPlayer = cdPlayer;
        this.dvdPlayer = dvdPlayer;
        this.popcornPopper = popcornPopper;
        this.projector = projector;
        this.screen = screen;
        this.theaterLight = theaterLight;
        this.tuner = tuner;
    }

    /**
     * 看电影
     */
    void watchMovie() {
        System.out.println("准备看一场电影 ...");

        // 打开爆米花机
        popcornPopper.on();
        // 开始爆米花
        popcornPopper.pop();

        // 将剧场灯光调暗
        theaterLight.dim(10);

        // 放下屏幕
        screen.down();

        // 打开投影仪
        projector.on();
        // 将投影仪的输入切换到 DVD
        projector.setInput(dvdPlayer);
        // 将投影仪设置在宽屏模式
        projector.wideScreenMode();

        // 打开功放
        amplifier.on();
        // 将功放的输入设置为 DVD
        amplifier.setDvd(dvdPlayer);
        // 将功放设置为环绕声
        amplifier.setSurroundSound();
        // 将功放音量调到中（5）
        amplifier.setVolume(5);

        // 打开 DVD 播放器
        dvdPlayer.on();
        // 开始播放 DVD
        dvdPlayer.play();
    }

    /**
     * 结束电影
     */
    void endMovie() {
        System.out.println("看电影结束 ...");
        // 关闭爆米花机
        popcornPopper.off();

        // 将剧场灯光打开
        theaterLight.on();

        // 升起屏幕
        screen.up();

        // 关闭投影仪
        projector.off();

        // 关闭功放
        amplifier.off();

        // 停止 DVD
        dvdPlayer.stop();

        // 弹出 DVD
        dvdPlayer.eject();

        // 关闭 DVD 播放器
        dvdPlayer.off();
    }

    /**
     * 听 CD
     */
    void listenToCd() {

    }

    /**
     * 结束 CD
     */
    void endCd() {

    }

    // other methods ...
}
