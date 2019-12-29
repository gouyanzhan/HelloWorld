package com.siwuxie095.forme.designpattern.category.chapter11th.example8th;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 具体调用处理器
 *
 * @author Jiajing Li
 * @date 2019-11-09 20:10:07
 */
class ConcreteInvocationHandler implements InvocationHandler {

    /**
     * 持有对主题的访问
     */
    private Subject subject;

    ConcreteInvocationHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            if (method.getName().equals("request")) {
                // 在方法调用前，可以做一些事情
                method.invoke(subject, args);
                // 在方法调用后，可以做一些事情
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
