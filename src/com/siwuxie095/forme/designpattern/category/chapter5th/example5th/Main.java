package com.siwuxie095.forme.designpattern.category.chapter5th.example5th;

/**
 * @author Jiajing Li
 * @date 2019-10-22 14:53:11
 */
public class Main {

    /**
     * 处理多线程
     *
     * 只要把 getInstance() 方法变成同步（synchronized）方法，多线程灾难
     * 几乎就可以轻易解决了。
     *
     * 通过增加 synchronized 关键字到 getInstance() 方法中，迫使每个线程
     * 在进入这个方法之前，要先等候别的线程离开该方法。也就是说，不会有后两个
     * 线程可以同时进入该方法。
     *
     * 但是该方法却有一点不好，因为同步会降低性能。而且对于该方法而言，只有第
     * 一次执行该方法时，才真正需要同步。换句话说，一旦设置好 uniqueInstance
     * 变量，就不再需要同步这个方法了。之后每次调用这个方法，同步都是一种累赘。
     *
     * 显然，为了符合大多数 Java 应用程序，是需要确保单例模式能够在多线程的
     * 状况下正常工作的。但是似乎同步 getInstance() 的做法将拖垮性能，该怎
     * 么办？
     *
     * 一些选择：
     * （1）如果 getInstance() 的性能对应用程序不是很关键，就什么都别做：
     * 如果你的应用程序可以接受 getInstance() 造成的额外负担，就忘了这件事。
     * 同步 getInstance() 的方法既简单又高效。但是，同步一个方法可能造成程
     * 序执行效率下降 100 倍。因此，如果将 getInstance() 的程序使用在频繁
     * 运行的地方，可能就得重新考虑了。
     *
     * 对于修改巧克力锅炉代码所遇到的问题的适用性：
     * 这是保证可行的最直接做法。对于巧克力锅炉似乎没有性能的考虑，所以可以用
     * 这个方法。
     */
    public static void main(String[] args) {
        ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
        chocolateBoiler.fill();
        chocolateBoiler.boil();
        chocolateBoiler.drain();
    }

}
