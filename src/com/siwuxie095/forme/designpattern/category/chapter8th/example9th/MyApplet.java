package com.siwuxie095.forme.designpattern.category.chapter8th.example9th;

import java.applet.Applet;
import java.awt.*;

/**
 * @author Jiajing Li
 * @date 2019-11-05 18:10:23
 */
class MyApplet extends Applet {

    private String message;

    @Override
    public void init() {
        message = "Hello World, I'm alive!";
        repaint();
    }

    @Override
    public void start() {
        message = "Now I'm starting up...";
        repaint();
    }

    @Override
    public void stop() {
        message = "Oh, now I'm being stopped...";
        repaint();
    }

    @Override
    public void destroy() {
        message = "Oh, now I'm being destroyed...";
        super.destroy();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawString(message, 5, 15);
    }
}
