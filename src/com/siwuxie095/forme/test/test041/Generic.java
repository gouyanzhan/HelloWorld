package com.siwuxie095.forme.test.test041;

import java.lang.reflect.ParameterizedType;

/**
 * @author Jiajing Li
 * @date 2020-06-24 10:11:16
 */
public interface Generic<T> {

    default Class<T> getGenericClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericInterfaces()[0];
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

}
