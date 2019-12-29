package com.siwuxie095.forme.designpattern.category.chapter9th.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-06 07:50:37
 */
public class Main {

    /**
     * 迭代器模式与组合模式：管理良好的集合
     *
     * 有许多种方法可以把对象堆起来称为一个集合（collection）。你可以
     * 把它们放进数组、堆栈、列表（List/Set）、散列表（Map）中，这是你
     * 的自由。
     * 每一种都有它自己的优点和适合的使用时机，但总有一个适合，你的客户
     * 想要遍历这些对象，而当他这么做时，你打算让客户看到你的实现吗？当
     * 然希望是最好不要，因为这太不专业了。
     * 在这里，将介绍如何能让客户遍历你的对象而又无法窥视你存储对象的方
     * 式；也会介绍如何创建一些对象的超集合（super collection），能够
     * 一口气就跳过某些让人生畏的数据结构。
     *
     *
     * 先说迭代器模式
     *
     * 现在有两个餐厅传来了要合并的消息，即 早餐餐厅和午餐餐厅。二者都
     * 同意用同一个菜单项，但早餐餐厅的菜单使用的是 List 来存储菜单项，
     * 午餐餐厅的菜单使用的是数组来存储菜单项。二者都不愿意改变自己的实
     * 现，因为有太多代码依赖各自的菜单了。
     *
     * 菜单项：
     * （1）名称 name
     * （2）描述 description
     * （3）是否素食 vegetarian
     * （4）价格 price
     *
     * 现在出现了两种不同的菜单表现方式（对于菜单项的存储方式不同），这
     * 会带来什么问题？
     *
     * 想要了解为什么有两种不同的菜单表现方式会让事情变得复杂化，可以试
     * 着实现一个同时使用这两个菜单的客户代码。假设现在要实现一个女招待，
     * 她能应对顾客的需要打印定制的菜单，甚至告诉你是否某个菜单项是素食
     * 的，而无须询问厨师。
     *
     * 对于 "打印出菜单上的每一项" 的方法 printMenu() 来说，里面都调
     * 用了各自菜单的 getMenuItems() 方法，但是二者的返回类型却不相同。
     * 一个是 List 类型，一个是数组类型。所以必须用两个不同的 for 循环
     * 来处理这两个不同的菜单。
     *
     * 对于女招待中的其它方法也是一样，大多都需要处理两个菜单，且需要用
     * 两个循环遍历这些项。如果还有第三家餐厅以不同方式出现，就需要有三
     * 个循环。
     *
     * 根据 printMenu() 方法的实现，可以看出如下问题：
     * （1）是针对 BreakfastMenu 和 LunchMenu 的具体实现编码，而不是
     * 针对接口。
     * （2）如果决定从 LunchMenu 切换到另一种菜单，其中的菜单项是用 Map
     * 来存储的，因此需要修改女招待中的许多代码。
     * （3）女招待需要知道每个菜单如何表达内部的菜单项集合，这违反了封装。
     * （4）存在重复的代码：printMenu() 方法需要两个循环来遍历两种不同
     * 的菜单。如果加上第三种菜单，就需要第三个循环。
     *
     *
     * 但早餐餐厅和午餐餐厅还是都不想改变自己的菜单实现，因为这意味要重写
     * 许多代码。这就导致女招待代码将难以维护，难以扩展。
     * 如果能找出一个办法，让他们的菜单实现一个相同的接口，那就好了。因为
     * 二者除了 getMenuItems() 方法的返回类型不同之外，是很相似的。
     * 这样一来，就可以最小化女招待代码中的具体引用，同时还有希望摆脱遍历
     * 这两个菜单所需的多个循环。
     */
    public static void main(String[] args) {
        Waitress waitress = new Waitress();
        waitress.printMenu();
        System.out.println();
        waitress.printVegetarianMenu();
    }

}
