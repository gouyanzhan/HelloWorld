package com.siwuxie095.forme.algorithm.chapter1st.question9th.answer1st;

import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-02-09 21:56:23
 */
public class RectangleSize {

    /**
     * 步骤 1
     */
    public static int maxRecSize(int[][] map) {
        if (null == map || map.length == 0 || map[0].length == 0){
            return 0;
        }
        // 初始化最大区域为 0
        int maxArea = 0;
        int[] height = new int[map[0].length];
        // 遍历行
        for (int i = 0; i < map.length; ++i) {
            // 遍历列（列数是固定的）
            for (int j = 0; j < map[0].length; ++j) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            // 二者取最大的
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    /**
     * 步骤 2
     */
    private static int maxRecFromBottom(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int currArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, currArea);
            }
            stack.push(i);
        }

        /*
         * 栈中还有元素没有经历向右延展的过程，直接弹栈，此时，i = height.length，相当于向右延展到极限，
         * 当栈为空时，k = -1，相当于向左延展到极限
         */
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int currArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }


}
