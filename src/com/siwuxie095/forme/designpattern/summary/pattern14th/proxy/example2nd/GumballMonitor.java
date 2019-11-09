package com.siwuxie095.forme.designpattern.summary.pattern14th.proxy.example2nd;

import java.rmi.RemoteException;

/**
 * 糖果监视器
 *
 * @author Jiajing Li
 * @date 2019-11-08 21:17:16
 */
class GumballMonitor {

    private GumballMachineRemote gumballMachine;

    GumballMonitor(GumballMachineRemote gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    void report() {
        try {
            System.out.println("------------------------------");
            System.out.println("Location: " + gumballMachine.getLocation());
            System.out.println("Count: " + gumballMachine.getCount());
            System.out.println("State: " + gumballMachine.getState().getClass().getSimpleName());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
