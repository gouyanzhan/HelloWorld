package com.siwuxie095.forme.test.test027;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Jiajing Li
 * @date 2020-03-26 16:57:27
 */
public class Main {

    /**
     * 说明的问题：
     * 1、通过递归和回溯，来获取对应class中某个字段的值（并不完善，有一定限制）。
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User();
        user.address = new Address();
        user.address.city = "Xiangyang";
        user.address.province = "Hubei";
        user.address.country = "China";
        System.out.println();
        System.out.println(getFieldValue(user, "country"));
        System.out.println();
        System.out.println(getFieldValue(user, "city"));
    }

    private static String getFieldValue(User user, String fieldName) throws IllegalAccessException {
        String[] fieldValue = new String[1];
        getFieldValue(user, user.getClass().getDeclaredFields(), fieldName, fieldValue);
        return  fieldValue[0];
    }

    private static boolean getFieldValue(Object object, Field[] fields, String fieldName, String[] fieldValue) throws IllegalAccessException {
        if (null == fields || fields.length == 0) {
            return false;
        }
        for (Field field : fields) {
            if (Modifier.isFinal(field.getModifiers())) {
                return false;
            }
            if (field.getName().equalsIgnoreCase(fieldName)) {
                fieldValue[0] = field.get(object).toString();
                return true;
            } else {
                try {
                    getFieldValue(field.get(object), field.get(object).getClass().getFields(), fieldName, fieldValue);
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }
}
