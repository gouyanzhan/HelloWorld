package com.siwuxie095.forme.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;


/**
 * 文件和文件夹的扫描器，用于遍历文件和文件夹
 *
 * @author Jiajing Li
 * @date 2019-01-09 16:00:44
 */
public class MyScannerUtils {

    public static void main(String[] args) {
        /*
         * ../HelloWorld
         * /Users/siwuxie095/IdeaProjects/HelloWorld
         */
        printFiles(new File("../HelloWorld"), 1);
    }

    /**
     * 遍历并打印文件夹
     *
     * @param dir 路径
     * @param tab 缩进量
     */
    public static void printFiles(File dir, int tab) {
        //先判断dir是否是路径
        if (dir.isDirectory()) {
            //File的listFiles()方法 返回File对象的数组，
            //其中包含了当前目录下的子文件和子文件夹结构
            //创建一个File类型的数组 next[]来接收返回值
            File next[]=dir.listFiles();
            //使用for循环来遍历当前的数组
            for (int i = 0; i < next.length; i++) {
            //在输出之前先缩进，根据tab的数量来确定缩进
                for (int j = 0; j < tab; j++) {
                    System.out.print("|--");
                }
                //无论当前的文件是文件还是文件夹，都输出其名称 getName()
                if (ignoreFileOrDirList.contains(next[i].getName())) {
                    continue;
                }
                System.out.println(next[i].getName());
                //如果是文件夹，需要再列出其下一级的所有的元素（内部的结构）
                if (next[i].isDirectory()) {
                    //循环调用，且下一级文件结构要多缩进一个 即 tab+1
                    printFiles(next[i], tab + 1);
                }
            }
        }
    }

    private static List<String> ignoreFileOrDirList = Arrays.asList(
            "out",
            "lib",
            ".git",
            ".gitignore",
            "gouyanzhan",
            ".idea",
            "HelloWorld.iml",
            "README.md",
            "uiDesigner.xml",
            "inspectionProfiles",
            "Project_Default.xml",
            ".DS_Store",
            "foryou",
            "algorithm",
            "",
            "",
            "",
            "",
            "",
            ""
    );

}
