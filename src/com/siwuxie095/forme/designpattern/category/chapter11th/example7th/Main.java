package com.siwuxie095.forme.designpattern.category.chapter11th.example7th;

/**
 * @author Jiajing Li
 * @date 2019-11-09 18:04:45
 */
public class Main {

    /**
     * 保护代理
     *
     * 现在要实现一个约会服务系统，要在其中加入 Hot 和 Not 的评鉴，Hot 表示喜欢
     * 对方，Not 表示不喜欢。你希望这套系统能鼓励你的顾客找到可能的配对对象，这也
     * 会让事情更有趣。
     *
     * 但竟然有人篡改别人的兴趣，还有人给自己评高分，以拉高自己的 HotOrNotRating
     * 值。这确实是不可取的。系统不应该允许用户篡改别人的兴趣，也不应该允许用户给自
     * 己打分数。
     *
     * 这正是一个使用保护代理的好例子。什么是保护代理？这是一种根据访问权限决定客户
     * 可否访问对象的代理。
     *
     * 在约会服务系统中，希望顾客可以设置自己的信息，同时又能防止他人更改这些信息。
     * HotOrNot 评分则相反，你不能更改自己的评分，但是他人可以设置你的评分。
     *
     * 但是现在 PersonBean 中的方法都是公开的，任何顾客都可以访问它们。
     */
    public static void main(String[] args) {

    }

}
