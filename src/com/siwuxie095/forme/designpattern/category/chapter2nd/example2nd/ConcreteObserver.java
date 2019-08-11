package com.siwuxie095.forme.designpattern.category.chapter2nd.example2nd;

/**
 * 具体观察者
 *
 * @author Jiajing Li
 * @date 2019-08-11 14:10:56
 */
class ConcreteObserver implements Observer {

    /**
     * 之所以保留对 Subject 的引用，是因为以后想要取消注册的时候会用到
     */
    private Subject subject;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        // 注册主题，以便接收更新
        subject.registerObserver(this);
    }

    @Override
    public void update(String state) {

    }
}
