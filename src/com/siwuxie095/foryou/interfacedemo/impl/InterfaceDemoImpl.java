package com.siwuxie095.foryou.interfacedemo.impl;

import com.siwuxie095.foryou.interfacedemo.api.InterfaceDemo;

/**
 * 实现类
 *
 * @author Jiajing Li
 * @date 2019-09-16 23:12:12
 */
public class InterfaceDemoImpl implements InterfaceDemo {

    private void printConst() {
        System.out.println("const value in InterfaceDemo: ");
        System.out.println(CONST_A);
        System.out.println(CONST_B);
        System.out.println(CONST_C);
        System.out.println("Implement class is InterfaceDemoImpl.");
    }

    @Override
    public String getDemo(int i) {
        System.out.println("getDemo:" + i);
        printConst();
        System.out.println("get value successfully.");
        return Integer.valueOf(i).toString();
    }

    @Override
    public void setDemo(int i) {
        System.out.println("setDemo:" + i);
        System.out.println("set value successfully.");
        printConst();
    }

    @Override
    public boolean saveDemo(String i) {
        System.out.println("saveDemo:" + i);
        printConst();
        System.out.println("save value successfully.");
        return true;
    }

    @Override
    public void deleteDemo(double i) {
        System.out.println("deleteDemo:" + i);
        printConst();
        System.out.println("delete value successfully.");
    }

    @Override
    public void updateDemo(float i) {
        System.out.println("updateDemo:" + i);
        printConst();
        System.out.println("update value successfully.");
    }
}
