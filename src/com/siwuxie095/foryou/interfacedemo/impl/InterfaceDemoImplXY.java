package com.siwuxie095.foryou.interfacedemo.impl;

import com.siwuxie095.foryou.interfacedemo.api.InterfaceDemoX;
import com.siwuxie095.foryou.interfacedemo.api.InterfaceDemoY;

/**
 * 实现类
 *
 * @author Jiajing Li
 * @date 2019-09-16 23:12:12
 */
public class InterfaceDemoImplXY implements InterfaceDemoX, InterfaceDemoY {


    @Override
    public void getDemoX() {
        System.out.println("getDemoX");
    }

    @Override
    public void getDemoY() {
        System.out.println("getDemoY");
    }
}
