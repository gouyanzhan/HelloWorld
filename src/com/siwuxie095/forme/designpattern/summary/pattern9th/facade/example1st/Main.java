package com.siwuxie095.forme.designpattern.summary.pattern9th.facade.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-04 19:51:54
 */
public class Main {

    public static void main(String[] args) {
        /*
         * 用轻松的方式观影
         */
        Amplifier amplifier = new Amplifier();
        CdPlayer cdPlayer = new CdPlayer();
        DvdPlayer dvdPlayer = new DvdPlayer();
        PopcornPopper popcornPopper = new PopcornPopper();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLight theaterLight = new TheaterLight();
        Tuner tuner = new Tuner();

        HomeTheaterFacade homeTheaterFacade =
                new HomeTheaterFacade(amplifier, cdPlayer, dvdPlayer,
                        popcornPopper, projector, screen,
                        theaterLight, tuner);

        homeTheaterFacade.watchMovie();
        System.out.println();
        homeTheaterFacade.endMovie();
    }

}
