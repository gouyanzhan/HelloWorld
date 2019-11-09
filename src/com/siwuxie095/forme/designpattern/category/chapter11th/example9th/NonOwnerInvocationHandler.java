package com.siwuxie095.forme.designpattern.category.chapter11th.example9th;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 非拥有者的调用处理器
 *
 * @author Jiajing Li
 * @date 2019-11-09 18:29:37
 */
class NonOwnerInvocationHandler implements InvocationHandler {

    private PersonBean personBean;

    NonOwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
                // 如果方法是 getter，就调用 PersonBean 中的方法
            if (method.getName().startsWith("get")) {
                return method.invoke(personBean, args);
                // 如果方法是 setHotOrNotRating()，因为这里是非拥有者，直接调用 PersonBean 中的方法
            } else if (method.getName().equals("setHotOrNotRating")) {
                return method.invoke(personBean, args);
                // 如果方法是 setter，因为这里是非拥有者，就抛出异常，表示不允许。
            } else if (method.getName().startsWith("set")) {
                throw new IllegalAccessException();
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
