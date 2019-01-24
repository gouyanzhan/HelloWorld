package com.siwuxie095.forme.algorithm.chapter1st.question6th.answer2nd;

/**
 * 用栈解决汉诺塔问题
 *
 * 首先介绍一下汉诺塔问题：
 * 汉诺塔源于印度传说中，大梵天创造世界时造了三根金钢石柱子，其中一根柱子自底向上叠着64片黄金圆盘。
 * 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。并且规定，在小圆盘上不能放大圆
 * 盘，在三根柱子之间一次只能移动一个圆盘。
 *
 * 即 分为三个柱子，左侧的 a 柱：起始柱；中间的 b 柱：中转柱；右侧的 c 柱：目标柱。
 *
 * 在a柱上从上往下，从小到大放着64个圆盘。
 *
 * 要求将a柱上的圆盘全部挪移到c柱上，且最终状态和a驻一样。在挪移过程中，小圆盘上不能放大圆盘。
 *
 * 在本题中，略微修改一下要求：限制不能从最左侧的 a 柱直接移动到最右侧的 c 柱，也不能从最右侧的
 * c 柱直接移动到最左侧的 a 柱，而是必须经过中间的 b 柱。
 *
 * 求：当 a 柱上有 N 个圆盘时，打印最优移动过程和最优移动总步数。
 *
 * 这里是法二：非递归的方法，用栈来模拟汉诺塔的三个塔
 *
 * @author Jiajing Li
 * @date 2019-01-20 16:47:05
 */
public class Main {

    public static void main(String[] args) {
        String left = "L";
        String mid = "M";
        String right = "R";
        int steps = SortHanoiTowerByStack.hanoiProblem(8, left, mid, right);
        System.out.println("Total steps are " + steps);
    }

}
