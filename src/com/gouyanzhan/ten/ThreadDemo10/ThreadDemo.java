package com.gouyanzhan.ten.ThreadDemo10;

/**
 * @author Yanzhan Gou
 * @date 2019-08-22 10:42:56
 */
class ThreadDemo extends Thread {
    private ShareData oshare;
    ThreadDemo(){}
    ThreadDemo(String szName,ShareData oShare){
        super(szName);
        this.oshare = oShare;
    }
    @Override
    public void run(){
        synchronized(oshare){
            for (int i = 0;i < 5;i++){
                if (this.getName().equals("Thread1")){
                    oshare.szData  = "这是第一个线程";
                    try {
                        Thread.sleep((int)Math.random()*50);
                    }catch (InterruptedException e){
                    }
                    System.out.println(this.getName()+":"+oshare.szData);
                }else if (this.getName().equals("Thread2")){
                    oshare.szData = "这是第二个线程";
                    try {
                        Thread.sleep((int)Math.random()*50);
                    }catch (InterruptedException e){}
                    System.out.println(this.getName()+":"+oshare.szData);
                }
            }
        }
    }
}
