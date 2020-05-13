package com.siwuxie095.forme.test.test036;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2020-05-13 16:50:34
 */
public class Main {

    /**
     * 说明的问题：
     * 1、测试使用递归法生成 N 位无重复字符的全排列（字典序，时间复杂度 N^2）；
     */
    public static void main(String[] args) {
        String[] strArr = new String[] {"A", "B", "C", "D", "E", "F", "G"};
        List<String[]> groupList = new ArrayList<>();

        getAllPermutation(strArr, 0, strArr.length, new String[strArr.length], groupList);

        for (String[] group : groupList) {
            Arrays.stream(group).forEach(System.out::print);
            System.out.println();
        }
    }

    /**
     * 1.
     * 先输出所有 A 开头的排列，接着输出所有 B 开头的排列，接着输出所有 C 开头的排列 ... (由外层 for 循环控制)
     *
     * 2.
     * 以 A 开头的排列，第一位是 A，后面是 B...G 的排列。
     * 以 AB 开头的排列，第一位是 A，第二位是 B，后面是 C...G 的排列。
     * 以 ABC 开头的排列，第一位是 A，第二位是 B，第三位是 C，后面是 D...G 的排列。
     * ...
     * 以 ABCDE 开头的排列，第一位是 A，第二位是 B，第三位是 C，第四位是 D，第五位是 E，后面是 F...G 的排列。
     * ...
     * (由递归控制)
     */
    private static void getAllPermutation(String[] strArr, int currentIdx, int length, String[] tmpArr, List<String[]> groupList) {
        if (currentIdx == length) {
            String[] group = tmpArr.clone();
            groupList.add(group);
            return;
        }
        for (int i = 0; i < length; i++) {
            // every element is matched or not.
            boolean matched = false;
            // use currentIdx to restrict matched bits.
            for (int j = 0; j < currentIdx; j++) {
                if (strArr[i].equals(tmpArr[j])) {
                    matched = true;
                }
            }
            if (!matched) {
                tmpArr[currentIdx] = strArr[i];
                getAllPermutation(strArr, currentIdx + 1, length, tmpArr, groupList);
            }
        }
    }

}
