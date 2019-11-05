package com.siwuxie095.forme.designpattern.category.chapter7th.example7th;

/**
 * 外观
 *
 * @author Jiajing Li
 * @date 2019-11-04 23:05:27
 */
class Facade {

    private SubSystemA subSystemA;

    private SubSystemB subSystemB;

    private SubSystemC subSystemC;

    private SubSystemN subSystemN;

    Facade(SubSystemA subSystemA,
                  SubSystemB subSystemB,
                  SubSystemC subSystemC,
                  SubSystemN subSystemN) {
        this.subSystemA = subSystemA;
        this.subSystemB = subSystemB;
        this.subSystemC = subSystemC;
        this.subSystemN = subSystemN;
    }

    Facade() {
        subSystemA = new SubSystemA();
        subSystemB = new SubSystemB();
        subSystemC = new SubSystemC();
        subSystemN = new SubSystemN();
    }

    /**
     * 统一的接口易于使用
     */
    void doSomething() {
        subSystemA.foo();
        subSystemB.bar();
        subSystemC.buz();
        subSystemN.fun();
    }
}
