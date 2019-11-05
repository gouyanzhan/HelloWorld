package com.siwuxie095.forme.designpattern.category.chapter8th.example5th;

/**
 * @author Jiajing Li
 * @date 2019-11-05 14:19:31
 */
public class Main {

    /**
     * 对模板方法进行挂钩
     *
     * 钩子是一种被声明在抽象类中的方法，但只有空的或者默认的实现。
     * 钩子的存在，可以让子类有能力对算法的不同点进行挂钩。要不要
     * 挂钩由子类自行决定。
     *
     * 在本例中，为 CaffeineBeverageWithHook 加入了一个钩子：
     * customerWantsCondiments() 方法。然后 CoffeeWithHook
     * 覆盖了该方法，提供了自己的实现。
     *
     *
     * 疑问与解答：
     *
     * 问：
     * 当我创建一个模板方法时，怎么才能知道什么时候该使用抽象方法，
     * 什么时候使用钩子呢？
     * 答：
     * 当你的子类 "必须" 提供算法中某个方法或步骤的实现时，就使用
     * 抽象方法。如果算法的这个部分是可选的，就用钩子。如果是钩子
     * 的话，子类可以选择实现这个钩子，但并不强制这么做。
     *
     * 问：
     * 使用钩子的真正目的是什么？
     * 答：
     * 钩子有几种用法。如之前所说，钩子可以让子类实现算法中可选的
     * 部分，或者在钩子对于子类的实现并不重要时，子类可以对此钩子
     * 置之不理。钩子的另一个用法，是让子类能够有机会对模板方法中
     * 某些即将发生的（或刚刚发生的）步骤作出反应。比如，有一个名
     * 为 justReOrderedList() 的钩子方法允许子类在内部列表重新
     * 组织后执行某些动作（例如在屏幕上重新显示数据）。正如刚才所
     * 看到的，钩子也可以让子类有能力为期抽象类做一些决定。
     *
     * 问：
     * 子类必须实现抽象类中的所有方法吗？
     * 答：
     * 是的，每个具体的子类都必须定义所有的抽象方法，并为模板方法
     * 中未定义步骤提供完整的实现。
     *
     * 问：
     * 似乎我应该保持抽象方法的数目越少越好，否则，在子类中实现这些
     * 方法将会很麻烦。
     * 答：
     * 当你在写模板方法的时候，心里随时要记得这一点。想要做到这一点，
     * 可以让算法内的步骤不要切割的太细，但是如果步骤太少的话，会比
     * 较没有弹性，所以要看情况折衷。
     * 也请记住，某些步骤是可选的，所以你可以将这些步骤实现成钩子，
     * 而不是实现成抽象方法，这样就可以让抽象类的子类的负荷减轻。
     */
    public static void main(String[] args) {
        CaffeineBeverageWithHook coffee = new CoffeeWithHook();
        coffee.prepareRecipe();

        System.out.println();

        CaffeineBeverageWithHook tea = new Tea();
        tea.prepareRecipe();
    }

}
