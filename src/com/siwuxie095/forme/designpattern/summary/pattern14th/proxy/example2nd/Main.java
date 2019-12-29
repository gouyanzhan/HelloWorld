package com.siwuxie095.forme.designpattern.summary.pattern14th.proxy.example2nd;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2019-11-08 12:57:38
 */
public class Main {

    /**
     * 有状态的糖果机
     *
     * 注意：让 State 扩展 Serializable
     *
     * 另外：让具体状态类中对糖果机的引用加上 transient 声明，以避免被序列化
     */
    public static void main(String[] args) {
        // 在 RMI Registry 中进行注册
        Registry reg = null;
        try {
            GumballMachineRemote gumballMachine1 = new GumballMachine("New York", 5);

            ((GumballMachine) gumballMachine1).insertCoin();
            ((GumballMachine) gumballMachine1).turnCrank();

            GumballMachineRemote gumballMachine2 = new GumballMachine("California", 5);

            ((GumballMachine) gumballMachine2).insertCoin();
            ((GumballMachine) gumballMachine2).turnCrank();

            List<GumballMachineRemote> gumballMachineList = new ArrayList<>();
            gumballMachineList.add(gumballMachine1);
            gumballMachineList.add(gumballMachine2);

            reg = LocateRegistry.createRegistry(8888);
            int count = 1;
            for (GumballMachineRemote gumballMachine : gumballMachineList) {
                reg.rebind("GumballMachine-" + count, gumballMachine);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 查找远程代理，找到后返回远程代理，然后通过该代理进行访问
        try {
            reg = LocateRegistry.getRegistry("127.0.0.1", 8888);
            String[] nameArr = {"GumballMachine-1", "GumballMachine-2"};
            for (String name : nameArr) {
                GumballMachineRemote gumballMachine = (GumballMachineRemote) reg.lookup(name);
                GumballMonitor gumballMonitor = new GumballMonitor(gumballMachine);
                gumballMonitor.report();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
