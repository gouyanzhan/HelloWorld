package com.siwuxie095.forme.test.test026;

import com.alibaba.fastjson.JSON;

/**
 * @author Jiajing Li
 * @date 2020-03-26 16:57:27
 */
public class Main {

    /**
     * 说明的问题：
     * 1、测试从对象的 JSON 字符串中得到对应属性的值。
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User();
        user.address = new Address();
        user.address.city = "Xiangyang";
        user.address.province = "Hubei";
        user.address.country = "China";
        Object o = user;
        String str = JSON.toJSONString(o);
        //String str = JSON.toJSONString(user);
        if (str.contains("city")) {
            int i = str.indexOf("city");
            str = str.substring(i);
            str = str.split(":")[1];
            str = str.split(",")[0];
            str = str.split("\"")[1];
            System.out.println(str);
        }
    }



}
