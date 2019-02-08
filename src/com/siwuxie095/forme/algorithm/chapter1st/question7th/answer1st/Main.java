package com.siwuxie095.forme.algorithm.chapter1st.question7th.answer1st;

/**
 * 生成窗口最大值数组
 *
 * 题目：
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边，
 * 窗口每次向右边滑一个位置。如果数组的长度为 n，窗口的大小为 w，则一共
 * 会产生 n - w + 1 个窗口的最大值。
 * 要求实现一个函数：
 * 1、输入：整型数组 arr，窗口大小为 w。
 * 2、输出：一个长度为 n - w + 1 的数组 res，res[i] 表示每一种窗口
 * 状态下的最大值。
 *
 * 解答：
 * 本题的关键在于利用双端队列来实现窗口最大值的更新。（所谓双端队列，即 队列的
 * 队头和队尾都可以做入队和出队的操作）
 *
 * 首先生成双端队列 qmax, qmax 中存放数组 arr 中的下标。
 *
 * 假设遍历到 arr[i]，qmax 的放入规则为：
 * 1、如果 qmax 为空，直接把下标 i 放进 qmax，放入过程结束。
 * 2、如果 qmax 不为空，取出当前 qmax 队尾存放的下标 j。
 * （1）如果 arr[j] > arr[i]，直接把下标 i 放进 qmax 的队尾，放入过程结束。
 * （2）如果 arr[j] <= arr[i]，把 j 从 qmax 中弹出，继续 qmax 的放入规则。
 *【放入规则，实际上就是队尾的入队与出队】
 *
 * 假设遍历到 arr[i]，qmax 的弹出规则为：
 * 如果 qmax 队头的下标等于 i - w，说明当前 qmax 队头的下标已过期，弹出当前
 * 队头的下标即可。
 * 【弹出规则，实际上就是队头的出队，这里没有入队】
 *
 * 根据以上规则，qmax 便成为了一个维护窗口为 w 的子数组的最大值更新的结构。
 *
 * 注意：由于 qmax 中存放的是下标，所以 qmax 的最大容量便是 w，且队头元素总是
 * 当前窗口最大元素对应的下标。
 *
 * @author Jiajing Li
 * @date 2019-02-08 15:24:51
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        int[] res = MaxWindow.getMaxWindow(arr, w);
        System.out.println("原数组 arr = " + getArrStr(arr));
        System.out.println("窗口最大值数组 res = " + getArrStr(res));
    }

    private static String getArrStr(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int val : arr) {
            builder.append(val).append(" ");
        }
        return builder.toString();
    }

}
