package com.siwuxie095.forme.designpattern.category.chapter1st.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-08-05 21:07:05
 */
public class Main {

    /**
     * 九个 OO 原则之第一个设计原则：
     * 找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码放在一起。
     *
     * 把会变化的部分取出并封装起来，好让其他部分不会受到影响。
     * 结果如何？代码变化引起的不经意后果变少，系统变得更有弹性。
     *
     * 把会变化的部分取出并封装起来，以便以后可以轻易地改动或扩充此部分，而不影响不需要变化的其他部分。
     *
     *
     * 九个 OO 原则之第二个设计原则：
     * 针对接口编程，而不是针对实现编程。
     *
     * "针对接口编程" 真正的意思是 "针对超类型（supertype）编程"。
     *
     * 这里说的接口是广义上的接口，并不仅仅是 interface 关键字声明的那种接口，还包括抽象类。
     * 即 接口 + 抽象类。
     *
     * 针对接口编程，关键就在多态。利用多态，程序可以针对超类型编程，执行时会根据实际状况执行到
     * 真正的行为，不会被绑死在超类型的行为上。
     *
     * 针对超类型编程，可以明确的表示为：变量的声明类型应该是超类型，通常是一个抽象类或者是一个
     * 接口，如此，只要是具体实现此超类型的类所产生的对象，都可以指定给这个变量。这也意味着，声
     * 明类时不用理会以后执行时的真正对象类型。
     *
     */
    public static void main(String[] args) {
        /*
         * 针对接口编程：知道该对象是狗，但是现在利用 animal 进行多态的调用。
         */
        Animal animal = new Dog();
        animal.makeSound();

        /*
         * 针对实现编程：声明变量 dog 为 Dog 类型（是 Animal 的具体实现），
         * 会造成必须针对具体实现编码。
         */
        Dog dog = new Dog();
        dog.makeSound();

        /*
         * 更棒的是，子类的实例化动作不再需要在代码中硬编码，例如 new Dog()，
         * 而是在运行时才指定具体实现的对象。
         *
         * 即 不知道实际的子类型是什么，只关心它知道如何正确的进行 makeSound()
         * 的动作就够了。
         */
        Animal animal1 = getAnimal("dog");
        animal1.makeSound();
        Animal animal2 = getAnimal("cat");
        animal2.makeSound();
    }

    private static Animal getAnimal(String type) {
        if (type.equals("dog")) {
            return new Dog();
        } else if (type.equals("cat")) {
            return new Cat();
        } else {
            throw new RuntimeException("类型错误");
        }
    }

}
