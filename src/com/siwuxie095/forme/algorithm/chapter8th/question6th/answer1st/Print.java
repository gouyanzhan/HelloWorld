package com.siwuxie095.forme.algorithm.chapter8th.question6th.answer1st;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Jiajing Li
 * @date 2019-05-27 15:08:58
 */
public class Print {

    //region 原问题

    public static void printHalfMajor(int[] arr) {
        int cand = 0;
        int times = 0;
        for (int i = 0; i != arr.length; i++) {
            if (times == 0) {
                cand = arr[i];
                times = 1;
            } else if (arr[i] == cand) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = 0; i != arr.length; i++) {
            if (arr[i] == cand) {
                times++;
            }
        }
        if (times > arr.length / 2) {
            System.out.println(cand);
        } else {
            System.out.println("no such number.");
        }
    }
    //endregion



    //region 进阶问题

    public static void printKMajor(int[] arr, int K) {
        if (K < 2) {
            System.out.println("the value if K is invalid.");
            return;
        }
        HashMap<Integer, Integer> cands = new HashMap<>();
        for (int i = 0; i != arr.length; i++) {
            if (cands.containsKey(arr[i])) {
                cands.put(arr[i], cands.get(arr[i]) + 1);
            } else {
                if (cands.size() == K - 1) {
                    allCandsMinusOne(cands);
                } else {
                    cands.put(arr[i], 1);
                }
             }
        }
        HashMap<Integer, Integer> reals = getReals(arr, cands);
        boolean hasPrint = false;
        for (Map.Entry<Integer, Integer> entry : cands.entrySet()) {
            Integer key = entry.getKey();
            if (reals.get(key) > arr.length / K) {
                hasPrint = true;
                System.out.print(key + " ");
            }
        }
        System.out.println(hasPrint ? "" : "no such number.");
    }

    private static void allCandsMinusOne(HashMap<Integer, Integer> map) {
        List<Integer> removeList = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) {
                removeList.add(key);
            }
            map.put(key, value - 1);
        }
        for (Integer removeKey : removeList) {
            map.remove(removeKey);
        }
    }

    private static HashMap<Integer, Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> reals = new HashMap<>();
        for (int i = 0; i != arr.length; i++) {
            int currNum = arr[i];
            if (cands.containsKey(currNum)) {
                if (reals.containsKey(currNum)) {
                    reals.put(currNum, reals.get(currNum) + 1);
                } else {
                    reals.put(currNum, 1);
                }
            }
        }
        return reals;
    }
    //endregion


}
