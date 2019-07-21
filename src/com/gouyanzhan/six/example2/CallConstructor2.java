package com.gouyanzhan.six.example2;

/**
 * @author Yanzhan Gou
 * @date 2019-07-21 14:37:56
 */
class D{
    D(){          //D类的无参构造器
        System.out.println("调用D的构造函数");
    }
    D(int i){    //A类的有参构造器
        System.out.println("调用D的有参构造函数");
    }
}
class E extends D{     //让E类继承D类
    E(){               //E类的无参构造器
        System.out.println("调用E的构造函数");
    }
    E(int i){        //E类的有参构造器
        super(5);    //调用父类的有参构造器
        System.out.println("调用E的有参构造函数");
    }
}
 class F extends E{   //让F类继承E类
    F(){              //C类无参构造器
        System.out.println("调用F的构造函数");
    }
    F(int i){        //F类的有参构造器
        super(5);  //调用父类也就是E类的有参构造器
        System.out.println("调用F的有参构造函数");
    }
}
public class CallConstructor2 {
    public static void main(String[] args){
        F c = new F();    //创建F类对象
        F C0 =new F(5);  //创建F类的具体有参对象
    }

}
