package com.siwuxie095.foryou.interfacedemo.impl;

import com.siwuxie095.foryou.interfacedemo.api.InterfaceDemo;

/**
 * 实现类
 *
 * @author Jiajing Li
 * @date 2019-09-16 23:12:12
 */
public class InterfaceDemoImpl0 implements InterfaceDemo {

    private void printConst() {
        System.out.println("const value in InterfaceDemo: ");
        System.out.println(CONST_A);
        System.out.println(CONST_B);
        System.out.println(CONST_C);
        System.out.println("Implement class is InterfaceDemoImpl0.");
    }

    @Override
    public String getDemo(int i) {
        System.out.println("getDemo:" + i);
        printConst();
        return Integer.valueOf(i).toString();
    }

    @Override
    public void setDemo(int i) {
        System.out.println("setDemo:" + i);
        printConst();
    }

    @Override
    public boolean saveDemo(String i) {
        System.out.println("saveDemo:" + i);
        printConst();
        return true;
    }

    @Override
    public void deleteDemo(double i) {
        System.out.println("deleteDemo:" + i);
        printConst();
    }

    @Override
    public void updateDemo(float i) {
        System.out.println("updateDemo:" + i);
        printConst();
    }
}
