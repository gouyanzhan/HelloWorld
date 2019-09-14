package com.gouyanzhan.ten.ThreadDemo9;

/**
 * @author Yanzhan Gou
 * @date 2019-08-22 10:26:01
 */
class ThreadDemo extends Thread {
    private ShareData oShare;
    ThreadDemo(){}
    ThreadDemo(String szName,ShareData oShare){
        super(szName);
        this.oShare = oShare;
    }
    @Override
    public void run(){
        for (int i = 0;i < 5;i++){
            if (this.getName().equals("Thread1")) {
                oShare.szData = "这是第一个线程";
                try {
                    Thread.sleep((int) Math.random() * 100);
                } catch (InterruptedException e) {

                }
                System.out.println(this.getName() + ":" + oShare.szData);
            }else if (this.getName().equals("Thread2"))
            {
                oShare.szData = "这是第二个线程";
                try {
                    Thread.sleep((int)Math.random()*100);
                }catch (InterruptedException e){}
                System.out.println(this.getName()+":" + oShare.szData);
            }
        }
    }

}
