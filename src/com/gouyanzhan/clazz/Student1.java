package com.gouyanzhan.clazz;

/**
 * @author Yanzhan Gou
 * @date 2019-03-21 11:16:25
 */
public class Student1 {
    /**
     * 饮料种类3种
     */
    public String[] categoryArr;

    /**
     * 单个饮料数量
     */
    public int[] singleCountArr;

    /**
     * 每种饮料的价格
     */
    public double[] priceArr;

    /**
     * 售卖机总钱数
     */
    public double totalMoney;

    /**
     * 总的饮料瓶数
     */
    public static int totalCount;




    public Student1(String[] categoryArr,int[] singleCountArr,double[] priceArr){
        if (check(categoryArr,singleCountArr,priceArr)){
            return;
        }
        this.priceArr = priceArr;
        this.singleCountArr = singleCountArr;
        this.categoryArr = categoryArr;
        int totalCount = 0;
        for (int i = 0; i < singleCountArr.length; i++){
            totalCount = totalCount + singleCountArr[i];
        }
        Student1.totalCount = totalCount;
    }

    private boolean check(String[] categoryArr,int[] singleCountArr,double[] priceArr){
        if (categoryArr == null || categoryArr.length == 0
        || singleCountArr == null || singleCountArr.length == 0
        || priceArr  == null || priceArr.length == 0){
            System.out.println("异常：饮料种类和单个饮料数量不能为0/空");
            return true;
        }
        if (categoryArr.length != singleCountArr.length || categoryArr.length != priceArr.length){
            System.out.println("长度不等");
            return true;
        }
        return false;
    }
    public void pay(String category,double money){
        if (!contains(category)){
            System.out.println("没有这款饮料");
            return;
        }
        if (categoryArr[0].equals(category)){
            if (less(priceArr[0],money)){
                return;
            }
            if (limit(singleCountArr[0],category,money)){
                return;
            }
            singleCountArr[0]--;
            totalCount--;
            totalMoney = totalMoney + priceArr[0];
            if (money > priceArr[0]){
                System.out.println(category + "已出库，将退您"+(money - priceArr[0])+"元");
            }else{
                System.out.println(category + "已出库");
            }
        } else if (categoryArr[1].equals(category)){
            if (less(priceArr[1],money)){
                return;
            }
            if (limit(singleCountArr[1],category,money)){
                return;
            }
            singleCountArr[1]--;
            totalCount--;
            totalMoney = totalMoney + priceArr[1];
            if (money > priceArr[1]){
                System.out.println(category + "已出库，将退您"+(money - priceArr[1])+"元");
            }else{
                System.out.println(category + "已出库");
            }
        }else{
            if (less(priceArr[2],money)){
                return;
            }
            if (limit(singleCountArr[2],category,money)){
                return;
            }
            singleCountArr[2]--;
            totalCount--;
            totalMoney = totalMoney + priceArr[2];
            if (money > priceArr[2]){
                System.out.println(category + "已出库，将退您"+(money - priceArr[2])+"元");
            }else{
                System.out.println(category + "已出库");
            }
        }
    }

    private boolean less(double standardPrice, double payment){
        if (payment < standardPrice){
            System.out.println("余额不足，将退回"+ payment +"元");
            return true;
        }
        return false;
    }

    private boolean contains(String category){
        for (int i =0; i < this.categoryArr.length;i++){
            if (categoryArr[i].equals(category)){
                return true;
            }
        }
        return false;
    }

    private boolean limit(int singleCount,String category,double payment){
        if (singleCount <= 0){
            System.out.println(category + "卖完了～，将退回"+ payment +"元");
            return true;
        }
        return false;
    }
}
