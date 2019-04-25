package com.siwuxie095.forme.algorithm.chapter5th.question15th.answer1st;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiajing Li
 * @date 2019-04-25 13:50:29
 */
public class Value {

    public static int getValue(String exp) {
        return value(exp.toCharArray(), 0)[0];
    }

    private static int[] value(char[] charArr, int i) {
        Deque<String> deq = new LinkedList<>();
        int pre = 0;
        int[] bra = null;
        while (i < charArr.length && charArr[i] != ')') {
            if (charArr[i] >= '0' && charArr[i] <= '9') {
                pre = pre * 10 + charArr[i++] - '0';
            } else if (charArr[i] != '(') {
                addNum(deq, pre);
                deq.addLast(String.valueOf(charArr[i++]));
                pre = 0;
            } else {
                bra = value(charArr, i + 1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(deq, pre);
        return new int[] {getNum(deq), i};
    }

    private static void addNum(Deque<String> deq, int num) {
        if (!deq.isEmpty()) {
            int curr = 0;
            String top = deq.pollLast();
            if ("+".equals(top) || "-".equals(top)) {
                deq.addLast(top);
            } else {
                curr = Integer.valueOf(deq.pollLast());
                num = "*".equals(top) ? (curr * num) : (curr / num);
            }
        }
        deq.addLast(String.valueOf(num));
    }

    private static int getNum(Deque<String> deq) {
        int res = 0;
        boolean add = true;
        String curr = null;
        int num = 0;
        while (!deq.isEmpty()) {
            curr = deq.pollFirst();
            if ("+".equals(curr)) {
                add = true;
            } else if ("-".equals(curr)) {
                add = false;
            } else {
                num = Integer.valueOf(curr);
                res += add ? num : (-num);
            }
        }
        return res;
    }

}
