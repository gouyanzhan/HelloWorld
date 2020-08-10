package com.siwuxie095.forme.test.test044;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Jiajing Li
 * @date 2020-08-10 17:41:54
 */
public class Main {

    public static void main(String[] args) {
        try {
            nested1();
        } catch (Exception e) {
            String str = stackTraceToString(e);
            System.out.println(str);
        }
    }

    private static void nested1() {
        nested2();
    }

    private static void nested2() {
        nested3();
    }

    private static void nested3() {
        throw new NullPointerException("null-pointer-exception-occurred");
    }

    public static String stackTraceToString(Throwable ex) {
        String str;
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            ex.printStackTrace(pw);
            pw.flush();
            sw.flush();
            str = sw.toString();
        } catch (Exception e) {
            str = "exception occurred: " + e.getMessage();
        }
        return str;
    }

}
