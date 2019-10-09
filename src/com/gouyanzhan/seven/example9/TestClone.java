package com.gouyanzhan.seven.example9;

/**
 * @author Yanzhan Gou
 * @date 2019-09-17 21:18:41
 */
public class TestClone {
    public static void main(String[] args){
        Addr addr = new Addr("中国","北京","朝阳区");
        Human1 zhangsan = new Human1("zhangsan",24,addr);
        Human1 lisi = (Human1)zhangsan.clone();
        System.out.println("张三的地址：");
        System.out.println(zhangsan.addr.country + zhangsan.addr.province + zhangsan.addr.city);
        System.out.println("李四的地址：");
        System.out.println(lisi.addr.country + lisi.addr.province+ lisi.addr.city);
        lisi.addr.country = "中国";
        lisi.addr.province = "山东";
        lisi.addr.city = "青岛";
        System.out.println("修改李四的地址为：中国山东青岛");
        System.out.println("张三的地址为：");
        System.out.println(zhangsan.addr.country + zhangsan.addr.province + zhangsan.addr.city);
        System.out.println("李四的地址为：");
        System.out.println(lisi.addr.country + lisi.addr.province+ lisi.addr.city);
    }

}
