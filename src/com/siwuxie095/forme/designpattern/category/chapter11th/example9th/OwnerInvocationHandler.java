package com.siwuxie095.forme.designpattern.category.chapter11th.example9th;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 拥有者的调用处理器
 *
 * @author Jiajing Li
 * @date 2019-11-09 18:23:46
 */
class OwnerInvocationHandler implements InvocationHandler {

    /**
     * 持有对人的引用
     */
    private PersonBean personBean;

    OwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    /**
     * 每次 Proxy 的方法被调用，就会导致 Proxy 调用此方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
                // 如果方法是 getter，就调用 PersonBean 中的方法
            if (method.getName().startsWith("get")) {
                return method.invoke(personBean, args);
                // 如果方法是 setHotOrNotRating()，因为这里是拥有者，就抛出异常，表示不允许。
            } else if (method.getName().equals("setHotOrNotRating")) {
                throw new IllegalAccessException();
                // 如果方法是 setter，因为这里是拥有者，所以任何 setter 方法
                // 都可以，直接调用 PersonBean 中的方法
            } else if (method.getName().startsWith("set")) {
                return method.invoke(personBean, args);
            }
            // 如果调用 PersonBean 中的方法抛出异常，就执行到这
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 如果调用其他的方法，一律不理，返回 null
        return null;
    }
}
