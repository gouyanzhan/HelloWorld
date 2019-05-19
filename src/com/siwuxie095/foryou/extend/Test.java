package com.siwuxie095.foryou.extend;

/**
 * @author Jiajing Li
 * @date 2019-03-18 12:40:11
 */
public class Test {

    public static void main(String[] args) {
        //testPet();
        //testBaseAndDerivedClass();
        //testDynamicBinding();
        testPetX();
    }

    private static void testPet() {
        Cat cat = new Cat();
        cat.name = "阿花";
        cat.sex = "女";
        cat.age = 3;
        cat.type = "猫";
        cat.catType = "美短猫";
        cat.weight = 10.0;
        cat.eat();
        cat.play();
        cat.climbTree();
        cat.talk();
        cat.sleep();
        cat.print();

        System.out.println();
        System.out.println();
        System.out.println();

        Dog dog = new Dog();
        dog.name = "阿黄";
        dog.sex = "公";
        dog.age = 4;
        dog.type = "狗";
        dog.dogType = "秋田犬";
        dog.weight = 15.0;
        dog.eat();
        dog.play();
        dog.wagTail();
        dog.talk();
        dog.sleep();
        dog.print();
    }

    private static void testBaseAndDerivedClass() {
        BaseClass base1 = new BaseClass();
        System.out.println();
        BaseClass base2 = new BaseClass("BASE");
        System.out.println();
        DerivedClass derived1 = new DerivedClass();
        System.out.println();
        DerivedClass derived2 = new DerivedClass("DERIVED");
        System.out.println();
        DerivedClass derived3 = new DerivedClass(9);
    }

    /**
     * 向上转型：子类对象转父类
     * 向下转型：父类对象转子类
     */
    private static void testDynamicBinding() {
        Pet[] petArr = new Pet[3];
        petArr[0] = new Cat();
        petArr[1] = new Dog();
        petArr[2] = new Pet();

        petArr[0].talk();
        petArr[1].talk();
        petArr[2].talk();

        ((Cat) petArr[0]).climbTree();
        ((Dog) petArr[1]).wagTail();

        System.out.println();

        Pet pet1 = new Cat();
        Pet pet2 = new Dog();
        Pet pet3 = new Pet();
        pet1.talk();
        pet2.talk();
        pet3.talk();

        ((Cat) pet1).climbTree();
        ((Dog) pet2).wagTail();

        System.out.println();

        /*
         * todo ...
         */
        //Cat cat = (Cat) new Pet();
        //cat.talk();
        //cat.climbTree();
        //
        //Dog dog = (Dog) new Pet();
        //dog.talk();
        //dog.wagTail();

        Cat cat = new Cat();
        Pet pet = cat;
        cat = (Cat) pet;
        cat.talk();
        cat.climbTree();

        Dog dog = new Dog();
        pet = dog;
        dog = (Dog) pet;
        dog.talk();
        dog.wagTail();
    }

    private static void testPetX() {
        //PetX petX = new PetX();
        PetX petX1 = new CatX();

        PetX petX2 = new DogX();

    }

}
