package com.siwuxie095.forme.designpattern.category.chapter7th.example7th;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-11-04 23:05:06
 */
class Client {

    /**
     * 这是一个快乐的客户，因为有了外观，
     * 客户的工作变得更容易了
     */
    void call() {
        Facade facade = new Facade();
        facade.doSomething();
    }

}
