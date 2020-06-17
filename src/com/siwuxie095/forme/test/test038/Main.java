package com.siwuxie095.forme.test.test038;

import java.io.*;

/**
 * @author Jiajing Li
 * @date 2020-06-17 16:20:28
 */
public class Main {

    /**
     * 说明的问题：
     * 1、lambda 表达式在一般情况下的序列化与反序列化；
     *
     *
     * 注意(Runnable & Serializable)是Java 8中新的语法。 cast an object to an intersection of types by adding multiple bounds.
     * https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.16
     *
     * 一个Lambda能否序列化， 要以它捕获的参数以及target type能否序列化为准。当然，不鼓励在实践中使用序列化。上面的例子r实现了Serializable
     * 接口，而且没有captured argument，所以可以序列化。
     *
     * 参考链接：https://colobu.com/2014/09/05/java-lambdas-hacking/#%E4%B8%80%E8%88%AC%E5%BA%8F%E5%88%97%E5%8C%96/%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Runnable r = (Runnable & Serializable)() -> System.out.println("hello serialization");
        FileOutputStream fos = new FileOutputStream("Runnable.lambda");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(r);
        FileInputStream fis = new FileInputStream("Runnable.lambda");
        ObjectInputStream is = new ObjectInputStream(fis);
        r = (Runnable) is.readObject();
        r.run();
    }

}
