package com.siwuxie095.forme.test.test032;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jiajing Li
 * @date 2020-05-11 17:54:26
 */
public class Main {
    /**
     * 说明的问题：
     * 1、测试生成 N 位 0 和 1 组成的数字的全排列；
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            // totalLevel = actualLevel + virtualLevel(root node is at this level)
            int[] heap = generateHeap(count + 1);
            boolean[] visited = new boolean[heap.length];
            List<int[]> groupList = new ArrayList<>();
            for (int i = 0; i < (int) Math.pow(2, count); i++) {
                int[] group = new int[count];
                dfs(heap, visited, 0, 1, count + 1, group);
                groupList.add(group);
            }
            System.out.println("detail:");
            for (int[] group : groupList) {
                Arrays.stream(group).forEach(System.out::print);
                System.out.println();
            }
            System.out.println("size:" + groupList.size());
            System.out.println("---------------------------------");
        }
    }

    private static int[] generateHeap(int totalLevel) {
        int num = (int) Math.pow(2, totalLevel);
        int[] heap = new int[num - 1];
        heap[0] = -1;
        heap[1] = 0;
        heap[2] = 1;
        for (int i = 1; i < (int) Math.pow(2, totalLevel - 1) - 1; i++) {
            heap[2 * i + 1] = 0;
            heap[2 * i + 2] = 1;
        }
        return heap;
    }

    private static void dfs(int[] heap, boolean[] visited, int index, int currLevel, int totalLevel, int[] group) {
        if (currLevel > totalLevel) {
            return;
        }
        if (!visited[index]) {
            if (2 * index + 1 < visited.length && !visited[2 * index + 1]) {
                dfs(heap, visited, 2 * index + 1, currLevel + 1, totalLevel, group);
            } else if (2 * index + 2 < visited.length && !visited[2 * index + 2]) {
                dfs(heap, visited, 2 * index + 2, currLevel + 1, totalLevel, group);
            }
            if (currLevel > 1) {
                group[currLevel - 2] = heap[index];
            }
            if (currLevel == totalLevel || (visited[2 * index + 1] && visited[2 * index + 2])) {
                visited[index] = true;
            }
        }
    }

}
