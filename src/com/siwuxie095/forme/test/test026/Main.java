package com.siwuxie095.forme.test.test026;

import com.alibaba.fastjson.JSON;

/**
 * @author Jiajing Li
 * @date 2020-03-26 16:57:27
 */
public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User();
        user.address = new Address();
        user.address.city = "Shanghai";
        user.address.province = "Shanghai";
        user.address.country = "China";
        Object o = user;
        String str = JSON.toJSONString(o);
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
