package com.siwuxie095.forme.designpattern.category.chapter11th.example3rd;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Jiajing Li
 * @date 2019-11-08 21:20:11
 */
public class Main {

    /**
     * 继续看糖果机、糖果监控器如何使用代理进行交互
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
