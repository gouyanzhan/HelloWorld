package com.siwuxie095.forme.designpattern.category.chapter2nd.example3rd;

/**
 * 观察者
 *
 * @author Jiajing Li
 * @date 2019-08-11 15:45:55
 */
interface Observer {

    /**
     * 更新
     */
    void update(float temperature, float humidity, float pressure);
}
