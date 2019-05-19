package com.siwuxie095.forme.algorithm.chapter3rd.question6th.answer1st;

import java.util.HashMap;

/**
 * @author Jiajing Li
 * @date 2019-03-20 22:15:20
 */
public class Length {

    public static int getMaxLength(Node head, int sum) {
        // key：累加和；value：累加和在路径中最早出现的层数（最短路径）。
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        // 重要，表示：累加和 0 不用包括任何节点就可以得到。
        sumMap.put(0, 0);
        return preOrder(head, sum, 0, 1, 0, sumMap);
    }

    /**
     * 先序遍历：根-左-右
     */
    private static int preOrder(Node head, int sum, int prevSum, int level, int maxLen, HashMap<Integer, Integer> sumMap) {
        if (null == head) {
            return maxLen;
        }
        // 累加和
        int currSum = prevSum + head.value;
        // 遍历到当前节点的累加和 currSum 在 sumMap 中不存在，就放进去
        if (!sumMap.containsKey(currSum)) {
            sumMap.put(currSum, level);
        }
        // sumMap 的 key 包含 当前累加和 和 指定累加和 的差值，求此时的最长路径
        if (sumMap.containsKey(currSum - sum)) {
            maxLen = Math.max(level - sumMap.get(currSum - sum), maxLen);
        }
        maxLen = preOrder(head.left, sum, currSum, level + 1, maxLen, sumMap);
        maxLen = preOrder(head.right, sum, currSum, level + 1, maxLen, sumMap);
        if (level == sumMap.get(currSum)) {
            sumMap.remove(currSum);
        }
        return maxLen;
    }

}
