package com.siwuxie095.forme.designpattern.category.chapter4th.example6th;

/**
 * @author Jiajing Li
 * @date 2019-10-12 17:53:55
 */
public class Main {

    /**
     * 工厂方法模式
     *
     * 定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。
     * 工厂方法让类把实例化推迟到子类。
     *
     *
     * 工厂方法模式能够封装具体类型的实例化。在本例中，抽象的
     * Creator 提供了一个创建对象的抽象方法，也称为 "工厂方法"。
     * 在抽象的 Creator 中，任何其他实现的方法，都可能使用到这
     * 个工厂方法所制造出来的产品，但只有子类真正实现了这个工厂
     * 方法并创建产品。
     *
     * 如同在正式定义中所说的，常常听其他开发人员说：工厂方法让
     * 子类决定要实例化的类是哪一个。
     * 这里希望不要理解错误，所谓的 "决定"，并不是指模式允许子
     * 类本身在运行时做决定，而是指编写创建者类时，不需要知道实
     * 际创建的产品是哪一个。选择了使用哪个子类，自然就决定了实
     * 际创建的产品是什么。
     *
     *
     * 问答释疑：
     *
     * 问：
     * 当只有一个 ConcreteCreator 的时候，工厂方法模式有什么
     * 优点？
     * 答：
     * 尽管只有一个具体创建者，工厂方法模式依然很有用，因为它帮
     * 助我们将产品的 "实现" 从 "使用" 中解耦，如果增加产品或
     * 者改变产品的实现，Creator 并不会受到影响（因为 Creator
     * 与任何 ConcreteProduct 之间都不是紧耦合）。
     *
     * 问：
     * 如果说 example4th 和 example5th 中 PizzaStore 的
     * 子类是利用简单工厂创建的，这样的说法是否正确？看起来倒
     * 是很像。
     * 答：
     * 它们很类似，但用法不同。虽然每个子类但实现看起来和简单
     * 工厂一样，但是别忘了，这里的每个子类都是扩展自一个类，
     * 此类有一个抽象的 createPizza() 方法。由每个子类自行
     * 负责 createPizza() 方法的行为。在简单工厂中，工厂是
     * 直接由 PizzaStore 使用的对象。
     *
     * 问：
     * 工厂方法和创建者是否总是抽象的？
     * 答：
     * 不，可以定义一个默认的工厂方法来产生某些具体的产品。这
     * 么一来，即使创建者没有任何子类，依然可以创建产品。
     *
     * 问：
     * 每个比萨店基于传入的类型制造不同种类的比萨。是否所有的
     * 具体创建者都必须如此？能不能只创建一种比萨？
     * 答：
     * 这里所采用的方式称为 "参数化工厂方法"。它可以根据传入
     * 的参数创建不同的对象。然而，工厂经常只产生一种对象，不
     * 需要参数化。模式的这两种形式都是有效的。
     *
     * 问：
     * 利用字符串传入参数化的类型，似乎有点危险，万一把 Clam
     * （蛤蜊）英文拼错，成了 Calm（平静），要求供应 CalmPizza
     * 怎么办？
     * 答：
     * 说得很对，这样的情形会造成所谓的 "运行时错误"。有几个
     * 其他更复杂的技巧可以避开这个麻烦，在编译时期就将参数上
     * 的错误抛出来。比如，可以创建代表参数类型的对象和使用静
     * 态常量 或者 Java5 所支持的 enum。
     * （PS：其实本来就用的是 enum 了）
     *
     * 问：
     * 对于简单工厂和工厂方法之间的差异，依然有些困惑。它们看
     * 起来很类似，差别在于，在工厂方法中，返回比萨的类是子类，
     * 能解释一下吗？
     * 答：
     * 子类的确看起来很像简单工厂，简单工厂把全部的事情，在一
     * 个地方都处理完了，然而工厂方法却是创建一个框架，让子类
     * 决定要如何实现。比方说，在工厂方法中，orderPizza()
     * 方法提供了一般的框架，以便创建比萨，orderPizza() 方
     * 法依赖工厂方法创建具体类，并制造出实际的比萨。
     * 可通过继承 PizzaStore 类，决定实际制造出的比萨是什么。
     * 简单工厂的做法，可以将对象的创建封装起来，但是简单工厂
     * 不具备工厂方法的弹性，因为简单工厂不能变更正在创建的产
     * 品。
     *
     * 问：
     * 工厂究竟能带来什么好处？
     * 答：
     * 有许多好处。将创建对象的代码集中在一个对象或方法中，可以
     * 避免代码中的重复，并且更方便以后的维护。这也意味着客户在
     * 实例化对象时，只会依赖于接口，而不是具体类。这有助于针对
     * 接口编程，而不针对实现编程。这让代码更具有弹性，可以应对
     * 未来的扩展。
     *
     * 问：
     * 现在知道封装创建对象的代码，就可以针对抽象编码，将客户代
     * 码和真实的实现解耦。然而在工厂代码中，不可避免的，仍然必
     * 须使用具体类来实例化真正的对象。这难道不是掩耳盗铃吗？
     * 答：
     * 对象的创建是现实的，如果不创建任何对象，就无法创建任何
     * Java 程序。然而，利用这个现实的知识，可将这些创建对象的
     * 代码用栅栏围起来，就像把所有的 "羊毛" 都堆到眼前，一旦
     * 围起来后，就可以保护这些创建对象的代码。如果让创建对象的
     * 代码到处乱跑，那就无法收集到 "羊毛"。
     */
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator1st();
        creator.anOperation("undefined");
    }

}
