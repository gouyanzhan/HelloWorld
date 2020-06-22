package com.siwuxie095.forme.test.test040;

import java.lang.reflect.ParameterizedType;

/**
 * @author Jiajing Li
 * @date 2020-06-18 13:40:19
 */
public abstract class Generic<T> {

    public Class<T> getGenericClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

}
