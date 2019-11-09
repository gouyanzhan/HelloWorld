package com.siwuxie095.forme.designpattern.category.chapter11th.example3rd;

import java.rmi.RemoteException;

/**
 * 糖果监视器
 *
 * @author Jiajing Li
 * @date 2019-11-08 21:17:16
 */
class GumballMonitor {

    private GumballMachineRemote gumballMachine;

    public GumballMonitor(GumballMachineRemote gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    void report() {
        try {
            System.out.println("Location: " + gumballMachine.getLocation());
            System.out.println("Count: " + gumballMachine.getCount());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
