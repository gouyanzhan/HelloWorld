package com.gouyanzhan.six.example3;

/**
 * @author Yanzhan Gou
 * @date 2019-07-21 16:22:32
 */
public class DynamicMethodDemo2 {
    public static void main(String[] args){
        Animal []animal = new Animal[3];
        animal[0] = new Animal();
        animal[1] = new Tiger();
        animal[2] = new Fish();
        DynamicMethodDemo2 dm  = new DynamicMethodDemo2();
        dm.move(animal[0]);
        dm.move(animal[1]);
        dm.move(animal[2]);
    }
    void move(Animal animal){
        //进行对象类型的判断
        if (animal instanceof Tiger){
            ((Tiger)animal).tigerRun();
        }
        else if (animal instanceof Fish) {
            ((Fish) animal).swim();
        }
        else {
            animal.sleep();
        }
    }

}
