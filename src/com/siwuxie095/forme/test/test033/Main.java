package com.siwuxie095.forme.test.test033;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2020-05-12 19:15:42
 */
public class Main {

    /**
     * 说明的问题：
     * 1、测试暴力生成 N 位无重复字符的全排列（时间复杂度 N^N）；
     */
    public static void main(String[] args) {
        String[] strArr = new String[] {"A", "B", "C", "D", "E", "F", "G"};
        int[] idxArr = new int[strArr.length];
        for (int i = 0; i < idxArr.length; i++) {
            idxArr[i] = i;
        }
        List<String[]> groupList = new ArrayList<>();
        buildGroupList(strArr, idxArr, groupList);

        for (String[] group : groupList) {
            Arrays.stream(group).forEach(System.out::print);
            System.out.println();
        }
    }

    private static void buildGroupList(String[] strArr, int[] idxArr, List<String[]> groupList) {
        int maxIdx = idxArr[idxArr.length - 1];
        groupList.add(strArr);
        int count = 0;
        while (true) {
            count++;
            toMultiSystemAndAddOne(idxArr, idxArr.length - 1, maxIdx);
            if (idxArr.length != distinctLength(idxArr)) {
                continue;
            }
            String[] group = new String[idxArr.length];
            for (int i = 0; i < idxArr.length; i++) {
                group[i] = strArr[idxArr[i]];
            }
            groupList.add(group);
            if (breakOrNot(idxArr, maxIdx)) {
                break;
            }
        }
        System.out.println(count);
    }

    private static boolean breakOrNot(int[] idxArr, int maxIdx) {
        for (int idx : idxArr) {
            if (idx != maxIdx--) {
                return false;
            }
        }
        return true;
    }

    private static void toMultiSystemAndAddOne(int[] idxArr, int i, int maxIdx) {
        if (idxArr[i] + 1 > maxIdx) {
            idxArr[i] = 0;
            if (i - 1 >= 0) {
                toMultiSystemAndAddOne(idxArr, i - 1, maxIdx);
            }
        } else {
            idxArr[i] += 1;
        }
    }



    private static int distinctLength(int[] idxArr) {
        return (int) Arrays.stream(idxArr).distinct().count();
    }

}
