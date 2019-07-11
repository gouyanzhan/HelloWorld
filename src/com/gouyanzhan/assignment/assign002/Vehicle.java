package com.gouyanzhan.assignment.assign002;

/**
 * @author Yanzhan Gou
 * @date 2019-06-01 11:59:17
 */
public class Vehicle {
    private double speed;
    private double size;
    public Vehicle(double a,double b){
        speed = a;
        size = b;
    }
    public void move(){
        System.out.println("移动");
    }
    public void setSpeed(double speed){
        this.speed = speed;
        System.out.println("速度为" + speed);
    }
    public double getSpeed() {
        return this.speed;
    }

    public void setSize(double size){
        this.size = size;
        System.out.println("体积为" + size);
    }

    public double getSize(){
        return this.size;
    }

    public void speedUp(){
        speed = speed + 10;
        System.out.println("加速后的速度"+speed);
    }
    public void speedDown(){
        if (check()){
            return;
        }
        speed = speed - 10;
        System.out.println("减速后的速度"+speed);

    }
   private boolean check(){
        if (speed <10 ){
            System.out.println("速度不能小于0");
            return true;
        }
        return false;
   }

}

//7、请定义一个交通工具(Vehicle)的类其中有: 属性速度(speed)体积(size)等等 方法移动(move())设置速度(setSpeed(int speed))
// 加速speedUp()减速speedDown()等等. 最后在测试类Vehicle中的main()中实例化一个交通工具对象并通过方法给它初始化speed,size
// 的值并且通过打印出来。另外调用加速减速的方法对速度进行改变。
