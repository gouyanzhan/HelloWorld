package com.siwuxie095.forme.designpattern.category.chapter2nd.example2nd;

/**
 * 观察者
 *
 * @author Jiajing Li
 * @date 2019-08-11 14:09:33
 */
interface Observer {

    /**
     * 更新（当主题状态变更时被调用）
     */
    void update(String state);

}
