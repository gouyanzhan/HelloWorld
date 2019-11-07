package com.siwuxie095.forme.designpattern.category.chapter9th.example9th;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2019-11-06 08:30:26
 */
public class Main {

    /**
     * 女招待代码中依然有一些 "问题"
     *
     * 其中连续三次调用了 printMenu()，这看起来有点丑。
     * 而且每次一有新菜单加入，就必须打开女招待的实现并
     * 加入更多的代码，这违背了 "开放-关闭原则"。
     *
     * 这不是女招待的错，对于将她从菜单的实现上解耦和提取
     * 遍历动作的到迭代器，都做的很好。但仍然将菜单处理成
     * 分离而独立的对象，所以需要一种一起管理它们的方法。
     *
     *
     * 新设计
     *
     * 将所有菜单打包进一个 List，然后取得它的迭代器，遍历
     * 每个菜单。这样一来，女招待的代码就变得很简单，而且菜
     * 单再多也不怕了。
     * （PS：由于无法区分早餐、午餐、晚餐，所以删掉了女招待
     * 中对应的打印代码。）
     *
     *
     * 正以为万无一失的时候，却出现了这样的场景
     *
     * 现在希望加一份午餐餐后甜点的 "子菜单"。即 不仅要支持
     * 多个菜单，还要支持菜单中的菜单。也就是说是一个树形结
     * 构。
     *
     * 显然，上面的新设计无法满足要求，还要再进行重构，以满足
     * 真 · 所有菜单（包含子菜单）。因为现在已经到达了一个复
     * 杂级别，如果现在不重新设计，就无法容纳未来增加的菜单或
     * 子菜单等需求。
     *
     * 所以需要：
     * （1）需要某种树形结构，可以容纳菜单、子菜单和菜单项。
     * （2）需要确定能够在每个菜单的各个项之间游走，而且至少
     * 要像现在用迭代器一样方便。
     * （3）需要能够更有弹性地在菜单项之间游走。比如，可能
     * 只需要遍历甜点菜单，或者遍历餐厅的整个菜单（包括甜点
     * 菜单在内）。
     */
    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();
        BreakfastMenu breakfastMenu = new BreakfastMenu();
        LunchMenu lunchMenu = new LunchMenu();
        DinnerMenu dinnerMenu = new DinnerMenu();

        menus.add(breakfastMenu);
        menus.add(lunchMenu);
        menus.add(dinnerMenu);

        Waitress waitress = new Waitress(menus);
        waitress.printMenu();
        System.out.println();
        waitress.printVegetarianMenu();
    }

}
