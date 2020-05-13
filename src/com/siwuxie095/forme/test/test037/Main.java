package com.siwuxie095.forme.test.test037;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2020-05-13 19:04:08
 */
public class Main {

    /**
     * 说明的问题：
     * 1、测试使用带标记的递归法生成 N 位无重复字符的全排列（字典序，时间复杂度 N^2）；
     */
    public static void main(String[] args) {
        String[] strArr = new String[] {"A", "B", "C", "D", "E", "F", "G"};
        List<String[]> groupList = new ArrayList<>();

        getAllPermutation(strArr, 0, strArr.length, new String[strArr.length], new boolean[strArr.length], groupList);

        for (String[] group : groupList) {
            Arrays.stream(group).forEach(System.out::print);
            System.out.println();
        }
    }

    private static void getAllPermutation(String[] strArr, int currentIdx, int length, String[] tmpArr, boolean[] visited, List<String[]> groupList) {
        if (currentIdx == length) {
            String[] group = tmpArr.clone();
            groupList.add(group);
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                tmpArr[currentIdx] = strArr[i];
                visited[i] = true;
                getAllPermutation(strArr, currentIdx + 1, length, tmpArr, visited, groupList);
                visited[i] = false;
            }
        }
    }

}
