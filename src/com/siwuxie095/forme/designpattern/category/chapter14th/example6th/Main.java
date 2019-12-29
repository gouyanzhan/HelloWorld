package com.siwuxie095.forme.designpattern.category.chapter14th.example6th;

/**
 * @author Jiajing Li
 * @date 2019-11-11 16:58:25
 */
public class Main {

    /**
     * 责任链模式
     */
    public static void main(String[] args) {
        Client client = new Client();
        Handler handler = client.createHandler();
        handler.handleRequest("one");
        handler.handleRequest("ten");
    }

}
