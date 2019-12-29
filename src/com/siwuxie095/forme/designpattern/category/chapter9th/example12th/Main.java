package com.siwuxie095.forme.designpattern.category.chapter9th.example12th;

/**
 * @author Jiajing Li
 * @date 2019-11-06 22:05:44
 */
public class Main {

    /**
     * 组合迭代器与空迭代器
     *
     *
     * 先说组合迭代器
     *
     * 现在女招待要使用迭代器来遍历整个组合。比如，女招待可能想要游走整个菜单，
     * 挑出素食项。
     *
     * 想要实现一个组合迭代器，需要为每个组件都加上 createIterator() 方法。
     *
     * 当在菜单组件中加入一个 createIterator() 后，菜单和菜单项都必须实现
     * 这个方法。同时意味着，对一个组合调用 createIterator() 方法，将会应
     * 用于该组合的所有孩子。
     *
     * 注意：Menu 中的 print() 方法实现的是一个 "内部" 迭代器，而 Composi-
     * teIterator 实现的则是一个 "外部" 迭代器，所以它有许多需要追踪的事情。
     * 外部迭代器必须维护它在遍历中的位置，以便外部客户可以通过调用 hasNext()
     * 和 next() 来驱动遍历。在本例中，代码也必须维护组合递归结构的位置。这
     * 也是为什么当我们在组合层次结构中上上下下时，使用栈来维护位置。
     *
     *
     * 再说空迭代器
     *
     * 对于菜单项中的 createIterator()，可以有两种处理方式：
     * （1）返回 null：
     * 可以直接返回 null，但这么做，客户代码就需要条件语句来判断返回值是否为 null。
     *
     * （2）返回一个迭代器，而这个迭代器的 hasNext() 永远返回 false：
     * 这个方案似乎更好。依然可以返回一个迭代器，客户不用担心返回值是否为 null。等于
     * 是创建了一个迭代器，其作用是 "没作用"，称之为 空迭代器。
     *
     *
     *
     * 模式与描述的配对：
     *
     * （1）策略模式：
     * 封装可互换的行为，并使用委托决定使用哪一个。
     *
     * （2）适配器模式：
     * 改变一个或多个类的接口。
     *
     * （3）迭代器模式：
     * 提供一个方式来遍历集合，而无须暴露集合的实现。
     *
     * （4）外观模式：
     * 简化一群类的接口。
     *
     * （5）组合模式：
     * 客户可以将对象的集合以及个别的对象一视同仁。
     *
     * （6）观察者模式：
     * 当某个状态改变时，允许一群对象被通知到。
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

        Waitress waitress = new Waitress(allMenus);
        waitress.printVegetarianMenu();
    }

}
