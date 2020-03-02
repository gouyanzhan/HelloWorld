package com.siwuxie095.foryou.threaddemo.example1st;

/**
 * @author Jiajing Li
 * @date 2019-12-27 23:31:11
 */
public class Main {

    /**
     * 什么是线程？
     * 线程是 CPU 进行任务调度的基本单位。假设有多个计算任务需要计算机去完成，
     * 那么每个任务从何时开始，到何时结束，每个任务需要多少资源（内存空间、磁
     * 盘空间等等），都是用线程去进行界定（线程的开始、线程的结束、线程所需的
     * 资源）。
     *
     * 一个线程就是程序中的一个顺序的执行流和控制流。
     *
     *
     * 线程与进程
     * 进程可联系 Windows 系统的任务管理器进行理解，可以看到任务管理器中有许多
     * 的进程正在运行。进程其实就是操作系统进行任务调度的基本单位。一个进程就是
     * 操作系统中的一个顺序的执行流和控制流。如：一个程序启动（如：QQ），会将该
     * 程序从磁盘加载到内存中进行运行，就会在操作系统中启动一个进程，来代表当前
     * 程序的运行。
     *
     * 进程中包含多个线程。也就是说在大的控制流中会有很多小的控制流。
     *
     *
     * 主线程
     * 其实以前的写的诸多代码，都是一个个的程序，也就是说，这些程序的执行（任务调度）
     * 必然也是以线程的形式体现的，因为它是在进行一个任务的执行，它有开始也有结束，
     * 它会分配内存，它是一个顺序的执行流和控制流。
     *
     * 由于是在 main() 方法中执行的，所以也被称为主线程。
     *
     *
     * 单线程与多线程
     * 当程序中只有一个线程时，就是单线程。当程序中有多个线程时，就是多线程。多线程
     * 有三种体现形式：
     * （1）同一份代码启动了多个线程。
     * （2）不同份（无关）代码各自启动了一个线程。
     * （3）混合。
     * 总而言之，表现为有多个线程正在运行。
     *
     *
     * 串行与并行
     * 可联系物理中的串联和并联进行理解。串行就是从上到下、从左到右，有顺序、有规律。
     * 而并行则没有顺序、没有规律。
     *
     * 在有多个任务需要执行时：
     * 串行执行，任务只能一个一个的执行，即便 CPU 现在有足够的能力。这样就会导致资源
     * 利用率下降，而且所有任务的完成时间也会拖慢。即 每个任务在执行时，单独占用 CPU
     * 时间，排在后面的任务被阻塞，无法得到执行。
     * 并行执行，没有依赖的任务就可以同时执行，充分利用 CPU 资源，加快整体任务的完成
     * 速度。即 多个任务可以同时拥有 CPU 时间，任务之间不会互相阻塞。
     *
     * 举例：烧水、泡茶、写作业、玩手机。
     *
     *
     * 并行与并发
     * 并行就是多个任务在同一个时间点同时开始执行，是多线程。
     * 并发就是多个任务在同一个时间段内同时执行（不一定同时开始），也是多线程。
     * （这就是多线程的目的，在多任务情况下，希望能够并行执行或并发执行，以提高效率）
     *
     *
     * 高并发
     * 在大促、活动期间，短时间内有大量用户发起购买，也就是有大量请求在某一个时间段内
     * 发送到服务端，服务端需要启动同一份代码的多个线程去进行处理。
     */
    public static void main(String[] args) {
        // 打印从 0～9
        int i = 0;
        while (true) {
            System.out.println(i++);
            if (i == 10) {
                break;
            }
        }
    }

}