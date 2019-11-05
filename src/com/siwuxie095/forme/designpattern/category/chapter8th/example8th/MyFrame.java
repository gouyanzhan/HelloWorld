package com.siwuxie095.forme.designpattern.category.chapter8th.example8th;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jiajing Li
 * @date 2019-11-05 18:01:07
 */
class MyFrame extends JFrame {

    /**
     * 初始化
     */
    public MyFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300, 300);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        String msg = "I rule!";
        graphics.drawString(msg, 100, 100);
    }
}
