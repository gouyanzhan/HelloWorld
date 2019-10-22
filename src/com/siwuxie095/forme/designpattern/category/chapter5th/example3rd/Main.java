package com.siwuxie095.forme.designpattern.category.chapter5th.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-10-22 14:17:09
 */
public class Main {

    /**
     * 巧克力工厂
     *
     * 现代化的巧克力工厂具备计算机控制的巧克力锅炉。锅炉做的事，就是把巧克力和牛奶
     * 融在一起，然后送到下一个阶段，以制造成巧克力棒。
     *
     * ChocolateBoiler 正是 Choc-O-Holic 公司的工业强度巧克力锅炉控制器的代码。
     * 可以看出，代码写的相当小心，他们在努力防止不好的事情发生。比如：排出 500 加
     * 仑未煮沸的混合物，或者锅炉已经满了还继续放原料，或者锅炉内还没放原料就开始空
     * 烧。
     *
     * 尽管如此，如果存在两个 ChocolateBoiler 实例，可能将发生很糟糕的事情。
     */
    public static void main(String[] args) {
        ChocolateBoiler chocolateBoiler = new ChocolateBoiler();
        chocolateBoiler.fill();
        chocolateBoiler.boil();
        chocolateBoiler.drain();
    }

}
