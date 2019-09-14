package com.gouyanzhan.six.example6;

/**
 * @author Yanzhan Gou
 * @date 2019-07-24 15:18:23
 */
public class Test {
    public static void mian(String[] args){
        //创建一个存放Object数据的数组
        Object []object = new Object[3];
     //   Animal animal1 = new Fish();
     //   Animal animal2 = new Tiger();
        //将上边创建的对象存数Object数组
    //    object[0] = animal1;
    //   object[1] = animal2;
        object[2] = new String("String");
        //取出对象后需要进行类型转换才能调用相应类型的方法
        ((Fish)object[0]).swim();
    }

}
