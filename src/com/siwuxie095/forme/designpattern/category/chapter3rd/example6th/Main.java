package com.siwuxie095.forme.designpattern.category.chapter3rd.example6th;

import java.io.*;

/**
 * @author Jiajing Li
 * @date 2019-10-10 15:58:03
 */
public class Main {

    /**
     * 真实世界的装饰者：Java I/O
     *
     * java.io 包内的类超级多，多到让人叹为观止！正是因为这些 I/O 相关的类采用了装饰者模式，
     * 其中有许多组件与装饰者，数量才会这么多。
     *
     * 比如，以下是一个典型的对象集合，用装饰者将功能结合起来，以读取数据：
     * （1）组件：InputStream。
     * （2）具体组件：FileInputStream、StringBufferInputStream、ByteArrayInputStream、ObjectInputStream、
     * PipedInputStream、SequenceInputStream，继承自 InputStream。
     * （3）装饰者：FilterInputStream，继承自 InputStream。
     * （4）具体装饰者：PushbackInputStream、BufferedInputStream、DataInputStream、LineNumberInputStream，
     * 继承自 FilterInputStream。
     *
     * 同理，OutputStream 亦是如此。另外，Reader、Writer 流的设计也是大同小异。
     *
     * 以 Reader 为例：
     * （1）组件：Reader。
     * （2）具体组件：BufferedReader、CharArrayReader、FileReader、InputStreamReader、LineNumberReader、
     * PipedReader、PushbackReader、StringReader，继承自 Reader。
     * （其中：FileReader 继承自 InputStreamReader，LineNumberReader 继承自 BufferedReader）
     * （3）装饰者：FilterReader，继承自 Reader。
     * （4）具体装饰者：PushbackReader。
     *
     *
     * 显然，星巴兹的设计和 java.io 其实并没有多大的差异。
     *
     * 从 Java I/0 可以看出装饰者模式的一个 "缺点"：利用装饰者模式，常常造成设计中有大量的小类，数量实在太多，
     * 可能会造成使用此 API 程序员的困扰。但是了解装饰者的工作原理后，再使用别人的大量装饰的 API 时，就可以很
     * 容易辨别出他们的装饰者类是如何组织的，以方便用包装方式取得想要的行为。
     *
     *
     * 编写一个新的 Java I/O 装饰者：将输入流内的所有大写字符转成小写字符。在当前包下创建一个文件 test.txt，
     * 其中有 "I know the Decorator Pattern therefore I RULE!"，装饰者会将其转换成 "i know the decorator
     * pattern therefore i rule!"。
     */
    public static void main(String[] args) {
        int c;
        try {

            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    "./src/com/siwuxie095/forme/designpattern/category/chapter3rd/example6th/test.txt")));

            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }

            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
