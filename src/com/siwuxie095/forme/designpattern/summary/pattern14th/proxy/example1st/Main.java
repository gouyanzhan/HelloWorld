package com.siwuxie095.forme.designpattern.summary.pattern14th.proxy.example1st;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Jiajing Li
 * @date 2019-11-08 21:20:11
 */
public class Main {

    /**
     * 简单的糖果机
     */
    public static void main(String[] args) {
        // 在 RMI Registry 中进行注册
        Registry reg = null;
        try {
            reg = LocateRegistry.createRegistry(8888);
            GumballMachineRemote gumballMachine = new GumballMachine("New York", 100);
            reg.rebind("GumballMachine", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 查找远程代理，找到后返回远程代理，然后通过该代理进行访问
        try {
            reg = LocateRegistry.getRegistry("127.0.0.1", 8888);
            GumballMachineRemote gumballMachine = (GumballMachineRemote) reg.lookup("GumballMachine");
            GumballMonitor gumballMonitor = new GumballMonitor(gumballMachine);
            gumballMonitor.report();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
