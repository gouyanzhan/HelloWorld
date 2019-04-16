package com.siwuxie095.forme.algorithm.chapter5th.question8th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-15 20:38:35
 */
public class Unique {

    //region 要求 1

    public static boolean isUnique1(char[] charArr) {
        if (null == charArr) {
            return true;
        }
        boolean[] map = new boolean[256];
        for (int i = 0; i < charArr.length; ++i) {
            if (map[charArr[i]]) {
                return false;
            }
            map[charArr[i]] = true;
        }
        return true;
    }
    //endregion


    //region 要求 2

    public static boolean isUnique2(char[] charArr) {
        if (null == charArr) {
            return true;
        }
        heapSort(charArr);
        for (int i = 1; i < charArr.length; ++i) {
            if (charArr[i] == charArr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void heapSort(char[] charArr) {
        for (int i = 0; i < charArr.length; ++i) {
            heapInsert(charArr, i);
        }
        for (int i = charArr.length - 1; i > 0; --i) {
            swap(charArr, 0, i);
            heapify(charArr, 0, i);
        }
    }

    private static void heapInsert(char[] charArr, int i) {
        int parent = 0;
        while (i != 0) {
            parent = (i - 1) / 2;
            if (charArr[parent] < charArr[i]) {
                swap(charArr, parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }

    private static void heapify(char[] charArr, int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        while (left < size) {
            if (charArr[left] > charArr[i]) {
                largest = left;
            }
            if (right < size && charArr[right] > charArr[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(charArr, largest, i);
            } else {
                break;
            }
            i = largest;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }
    }

    private static void swap(char[] charArr, int index1, int index2) {
        char tmp = charArr[index1];
        charArr[index1] = charArr[index2];
        charArr[index2] = tmp;
    }
    //endregion

}
