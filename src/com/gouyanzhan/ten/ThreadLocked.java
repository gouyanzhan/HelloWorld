package com.gouyanzhan.ten;

/**
 * @author Yanzhan Gou
 * @date 2019-08-22 17:00:29
 */
public class ThreadLocked implements Runnable {
    public static boolean flag = true;
    private static Object A = new Object();
    private static Object B = new Object();
    public static void main(String[] args)throws InterruptedException{
        Runnable r1 = new ThreadLocked();
        Thread t1 = new Thread(r1);
        Runnable r2 = new ThreadLocked();
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
    public void AccessA(){
        flag = false;
        synchronized (A){
            System.out.println("线程t1：我得到了A的锁");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("线程t1：我还想要得到B的锁");
            synchronized (B){
                System.out.println("线程t1：我得到了B的锁");
            }
        }
    }
    public void AccessB(){
        flag = true;
        synchronized (B){
            System.out.println("线程t2：我得到了B的锁");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("线程t2：我还想要得到A的锁");
            synchronized (A){
                System.out.println("线程t2：我得到了A的锁");
            }
        }
    }
    @Override
    public void run(){
        if (flag){
            AccessA();
        }else{
            AccessB();
        }
    }

}
