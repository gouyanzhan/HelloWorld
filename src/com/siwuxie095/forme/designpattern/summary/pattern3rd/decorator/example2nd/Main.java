package com.siwuxie095.forme.designpattern.summary.pattern3rd.decorator.example2nd;

import java.io.*;

/**
 * @author Jiajing Li
 * @date 2019-10-10 15:58:03
 */
public class Main {


    public static void main(String[] args) {
        int c;
        try {

            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    "./src/com/siwuxie095/forme/designpattern/summary/pattern3rd/decorator/example2nd/test.txt")));

            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }

            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
