package com.siwuxie095.forme.designpattern.summary.pattern2nd.observer.example1st;

/**
 * 观察者
 *
 * @author Jiajing Li
 * @date 2019-08-12 23:19:39
 */
interface Observer {

    /**
     * 更新
     */
    void update(float temperature, float humidity, float pressure);
}

