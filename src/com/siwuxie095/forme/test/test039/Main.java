package com.siwuxie095.forme.test.test039;

import java.io.*;

/**
 * @author Jiajing Li
 * @date 2020-06-17 16:29:15
 */
public class Main {

    /**
     * 说明的问题：
     * 1、lambda 表达式在带捕获变量情况下的序列化与反序列化；
     *
     * 可以看到连同 captured argument sample 一同序列化了。 即使反序列化出来，
     * captured argument也不是原来的 sample 了。
     * 结果输出hello first。
     */
    public static void main(String[] args) throws Exception {
        serializeLambda();
        deserializeLambda();
    }


    public static void serializeLambda() throws Exception {
        Sample sample = new Sample();
        sample.setStr("first");
        Runnable r = (Runnable & Serializable) () -> System.out.println("hello " + sample.getStr());
        FileOutputStream fos = new FileOutputStream("Runnable.lambda");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        // 注意位置变化的区别
        //s.setStr("second");
        os.writeObject(r);
        sample.setStr("second");
    }
    public static void deserializeLambda() throws Exception {
        FileInputStream fis = new FileInputStream("Runnable.lambda");
        ObjectInputStream is = new ObjectInputStream(fis);
        Runnable r = (Runnable) is.readObject();
        r.run();
    }

    static class Sample implements Serializable {

        private String str;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }

}
