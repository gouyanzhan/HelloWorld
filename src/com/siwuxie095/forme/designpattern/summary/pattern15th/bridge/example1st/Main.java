package com.siwuxie095.forme.designpattern.summary.pattern15th.bridge.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-11 14:14:01
 */
public class Main {

    public static void main(String[] args) {
        TV sharpTV = new SharpTV();
        TV sonyTV = new SonyTV();

        RemoteControl remoteControl1st = new ConcreteRemoteControl1st(sharpTV);
        RemoteControl remoteControl2nd = new ConcreteRemoteControl2nd(sharpTV);

        remoteControl1st.setChannel(10);
        remoteControl1st.previousChannel();

        System.out.println();

        remoteControl2nd.setChannel(20);
        remoteControl2nd.nextChannel();
    }

}
