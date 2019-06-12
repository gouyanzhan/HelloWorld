package com.siwuxie095.forme.algorithm.chapter9th.question1st.answer1st;

/**
 * 从 5 随机到 7 随机及其扩展
 *
 * 题目：
 * 给定一个等概率随机产生 1～5 等随机函数 rand1To5 如下：
 * public int rand1To5() {
 *     return (int) (Math.random() * 5) + 1;
 * }
 * 除此之外，不能使用任何额外的随机机制，请用 rand1To5 实现等概率随机产生 1～7 等随机函数 rand1To7。
 *
 * 补充题目:
 * 给定一个以 p 概率产生 0，以 1-p 概率产生 1 的随机函数 rand01p 如下：
 * public int rand01p() {
 *      // 可随意改变 p
 *     double p = 0.83;
 *     return Math.random() < p ? 0 : 1;
 * }
 * 除此之外，不能使用任何随机机制，请用 rand01p 实现等概率随机产生 1～6 等随机函数 rand1To6。
 *
 * 进阶题目：
 * 给定一个等概率随机产生 1～M 的随机函数 rand1ToM 如下：
 * public int rand1ToM(int m) {
 *     return (int) (Math.random() * m) + 1;
 * }
 * 除此之外，不能使用任何额外的随机机制。有两个输入参数，分别为 m 和 n，请用 rand1ToM(m) 实现等概率
 * 随机产生 1～n 的随机函数 rand1ToN。
 *
 * 解答：
 * 先解决原问题，具体步骤如下：
 * 1、rand1To5() 等概率随机产生 1，2，3，4，5。
 * 2、rand1To5() - 1 等概率随机产生 0，1，2，3，4。
 * 3、(rand1To5() - 1) * 5 等概率随机产生 0，5，10，15，20。
 * 4、(rand1To5() - 1) * 5 + (rand1To5() - 1) 等概率随机产生 0，1，2，3，...，23，24。注意，这
 * 两个 rand1To5() 是指两次独立的调用，请不要化简。这是 "插空儿" 的过程。
 * 5、如果步骤 4 产生的结果大于 20，则重复进行步骤 4，直到产生的结果 0～20 之间。同时可以轻易知道出现
 * 21～24 的概率，会平均分配到 0～20 上。这是 "筛" 的过程。
 * 6、步骤 5 会等概率随机产生 0～20，所以步骤 5 的结果再进行 %7 操作，就会等概率的随机产生 0～6。
 * 7、步骤 6 的结果再加 1，就会等概率地随机产生 1～7。
 *
 * 然后是补充问题。虽然 rand01p 方法以 p 的概率产生 0，以 1-p 的概率产生 1，但是 rand01p 产生 01 和
 * 10 的概率却都是 p(1-p)，可以利用这一点来实现等概率随机产生 0 和 1 的函数。具体代码请参看 rand01 方
 * 法。
 * 有了等概率随机产生 0 和 1 的函数后，再按照如下步骤生成等概率随机产生 1～6 的函数：
 * 1、rand01() 方法可以等概率随机产生 0 和 1。
 * 2、rand01()*2 等概率随机产生 0 和 2。
 * 3、rand01()*2 + rand01() 等概率随机产生 0，1，2，3。注意，这两个 rand01() 是指独立的两次调用，请
 * 不要化简。这是 "插空儿" 的过程。步骤 3 已经实现了等概率随机产生 0～3 的函数，具体代码请参看 rand0To3
 * 方法。
 * 4、rand0To3()*4 + rand0To3() 等概率随机产生 0，1，2，...，14，15。注意，这两个 rand0To3() 是指
 * 独立的两次调用，请不要化简。这还是 "插空儿" 的过程。
 * 5、如果步骤 4 产生的结果大于 11，则重复进行步骤 4，直到产生的结果在 0～11 之间。那么可以知道出现 12～
 * 15 的概率会平均分配到 0～11 上。这是 "筛" 的过程。
 * 6、因为步骤 5 的结果是等概率随机产生 0～11，所以用第 5 步的结果再进行 %6 操作，就会等概率随机产生 0～
 * 5。
 * 7、第 6 步的结果再加 1，就会等概率随机产生 1～6。
 *
 * 最后是进阶问题。如果读者真正理解了 "插空儿" 和 "筛" 的过程，就可以知道，只要给定某一个区间上的等概率随机
 * 函数，就可以实现任意区间上的随机函数。所以，如果 M >= N，直接进入如上所述的 "筛" 过程；如果 M < N，先
 * 进入如上所述的 "插空儿" 过程，直到产生比 N 的范围还大的随机范围后，再进入 "筛" 过程。具体的说，是调用 k
 * 次 rand1ToM(m)，生成有 k 位的 M 进制数，并且产生的范围要大于或等于 N。比如随机 5 到 随机 7 的问题，
 * 首先生成 0～24 范围的数，其实就是 0～(5^2-1) 范围的数。再把范围扩到大于或等于 N 的级别之后，如果真实生
 * 成的数大于或等于 N，就忽略，也就是 "筛" 的过程。只留下小于或等于 N 的数，那么在 0～N-1 上就可以做到均匀
 * 分布。具体代码请参看 rand1ToN 方法。
 *
 * @author Jiajing Li
 * @date 2019-06-12 09:25:13
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Random.rand1To7());
        System.out.println(Random.rand1To6());
        System.out.println(Random.rand1ToN(5, 8));
    }

}
