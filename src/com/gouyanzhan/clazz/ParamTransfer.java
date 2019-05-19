package com.gouyanzhan.clazz;

/**
 * @author Yanzhan Gou
 * @date 2019-03-19 14:29:19
 */
public class ParamTransfer {
    public int money;
    void amethod(int i){
        //注意对比形参 i 和 money 的值的变化
        System.out.println("方法得到的i的值为："+ i );
        i = i * 5;
        System.out.println("方法执行语句i = i * 5 后的值为："+i);
        System.out.println("money的值为："+this.money);
    }
    public static void main(String []args){
        ParamTransfer pt = new ParamTransfer();
        pt.money = 100;
        //把money作为参数传递给方法
        pt.amethod(pt.money);
    }

}
