package com.siwuxie095.forme.designpattern.category.chapter9th.example10th;

/**
 * @author Jiajing Li
 * @date 2019-11-06 22:05:44
 */
public class Main {

    /**
     * 组合模式
     *
     * 允许你将对象组合成树形结构来表现 "整体/部分" 层次结构。组合能让客户
     * 以一致的方式处理个别对象以及对象组合。
     *
     * （其中，没有父节点的节点称为 根节点，带子节点的节点称为 非叶子节点，
     * 而没有子节点的节点称为 叶子节点）
     *
     *
     * 没错，正是要利用组合模式来解决 example9th 中的树形菜单难题。这个
     * 模式能够创建一个树形结构，在同一个结构中处理嵌套菜单和菜单项组。通
     * 过将菜单和菜单项放在相同的结构中，就创建了 "整体/部分" 层次结构，
     * 即 由菜单和菜单项组成的对象树。但是可以将它视为一个整体，像是一个
     * 丰富的大菜单。
     * 一旦有了丰富的大菜单，就可以用这个模式来 "统一处理个别对象和组合
     * 对象"。这意味着，如果有了一个树形结构的菜单、子菜单和可能还带有菜
     * 单项的子菜单，那么任何一个菜单都是一种 "组合"。因为它既可以包含
     * 其他菜单，也可以包含菜单项。个别对象只是菜单项，并未持有其他对象。
     *
     * 对应关系如下：
     * （1）丰富的大菜单 = 根节点 = 组件
     * （2）菜单 = 非叶子节点 = 组合
     * （3）菜单项 = 叶子节点 = 个别
     *
     * 通过遵照组合模式的设计，就能够对整个菜单结构应用相同的操作。比如，
     * 打印。
     *
     *
     * 总得来说
     *
     * 组合模式让我们能用树形方式创建对象的结构，树里面包含了组合对象以
     * 及个别的对象。
     * 使用组合结构，我们能把相同的操作应用在组合对象和个别对象上。换句
     * 话说，在大多数情况下，我们可以忽略组合对象和个别对象之间的差别。
     *
     *
     * 利用组合设计菜单
     *
     * 首先需要创建一个组件接口来作为菜单（组合）和菜单项（个别）的共同
     * 接口，让我们能用统一的做法来处理菜单和菜单项。换句话说，可以针对
     * 菜单或菜单项调用相同的方法。
     *
     * 但是组合模式却违背了 "一个类，一个责任"，因为它不仅要管理层次结
     * 构，还要执行菜单和菜单项的操作。其实这里组合模式是以单一责任设计
     * 原则换取透明性（transparency）。
     *
     * 什么是透明性？
     * 通过让组件的接口同时包含一些管理组合对象和个别对象的操作，客户就
     * 可以将组合对象和个别对象一视同仁。也就是说，一个节点究竟是组合对
     * 象还是个别对象，对客户是透明的。
     *
     * 现在，MenuComponent 类中同时具有两种类型的操作。因为客户有机会
     * 对一个元素做一些不恰当的或是没有意义的操作（例如试图把菜单添加到
     * 菜单项），所以就失去了一些 "安全性"。这是设计上的抉择，当然也可
     * 以采用另一种方向的设计，将责任区分开来放到不同的接口中。这么一来，
     * 设计上就比较安全，但是也因此失去了透明性，客户的代码将必须用条件
     * 语句和 instanceof 操作符处理不同类型的节点。
     *
     * 所以这是一个很典型的折衷案例。尽管我们受到设计原则的指导，但是我
     * 们总是需要观察某原则对设计所造成的影响。有时候，我们会故意做一些
     * 看似违反原则的事情。然而，在某些例子中，这是观点的问题。比如，让
     * 管理非叶子节点的操作 add()、remove()、getChild() 出现在叶子
     * 节点中，似乎很不恰当，但是换个视角看，你可以叶子节点视为没有子节
     * 点的节点（意思是都是节点）。
     */
    public static void main(String[] args) {
        MenuComponent breakfastMenu = new Menu("Breakfast Menu", "Good");
        MenuComponent lunchMenu = new Menu("Lunch Menu", "Fine");
        MenuComponent dinnerMenu = new Menu("Dinner Menu", "OK");

        MenuComponent dessertMenu = new Menu("Dessert Menu", "Fantastic");

        MenuComponent allMenus = new Menu("All Menus", "Combined");

        allMenus.add(breakfastMenu);
        allMenus.add(lunchMenu);
        allMenus.add(dinnerMenu);

        MenuComponent breakfastA = new MenuItem("早餐 A", "早餐 A：...", true, 3.99);
        MenuComponent breakfastB = new MenuItem("早餐 B", "早餐 B：...", false, 4.99);
        MenuComponent breakfastC = new MenuItem("早餐 C", "早餐 C：...", true, 5.99);
        breakfastMenu.add(breakfastA);
        breakfastMenu.add(breakfastB);
        breakfastMenu.add(breakfastC);

        MenuComponent lunchA = new MenuItem("午餐 A", "午餐 A：...", true, 15.99);
        MenuComponent lunchB = new MenuItem("午餐 B", "午餐 B：...", false, 16.99);
        MenuComponent lunchC = new MenuItem("午餐 C", "午餐 C：...", true, 17.99);
        lunchMenu.add(lunchA);
        lunchMenu.add(lunchB);
        lunchMenu.add(lunchC);
        lunchMenu.add(dessertMenu);

        MenuComponent dinnerA = new MenuItem("晚餐 A", "晚餐 A：...", true, 23.99);
        MenuComponent dinnerB = new MenuItem("晚餐 B", "晚餐 B：...", false, 24.99);
        MenuComponent dinnerC = new MenuItem("晚餐 C", "晚餐 C：...", true, 25.99);
        dinnerMenu.add(dinnerA);
        dinnerMenu.add(dinnerB);
        dinnerMenu.add(dinnerC);

        MenuComponent dessertA = new MenuItem("午后甜点 A", "午后甜点 A：...", true, 0.99);
        MenuComponent dessertB = new MenuItem("午后甜点 B", "午后甜点 B：...", false, 0.99);
        MenuComponent dessertC = new MenuItem("午后甜点 C", "午后甜点 C：...", true, 0.99);
        dessertMenu.add(dessertA);
        dessertMenu.add(dessertB);
        dessertMenu.add(dessertC);

        //{
        //    Waitress waitress = new Waitress(dessertA);
        //    waitress.printMenu();
        //}

        //{
        //    Waitress waitress = new Waitress(dessertMenu);
        //    waitress.printMenu();
        //}

        //{
        //    Waitress waitress = new Waitress(lunchMenu);
        //    waitress.printMenu();
        //}

        {
            Waitress waitress = new Waitress(allMenus);
            waitress.printMenu();
        }
    }

}
