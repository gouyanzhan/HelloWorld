package com.siwuxie095.forme.algorithm.chapter4th.question13th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-07 23:16:50
 */
public class Number {

    public static int num1(String express, boolean desired) {
        if (null == express || "".equals(express)) {
            return 0;
        }
        char[] expArr = express.toCharArray();
        if (!isValid(expArr)) {
            return 0;
        }
        return p(expArr, desired, 0, expArr.length - 1);
    }

    private static int p(char[] expArr, boolean desired, int l, int r) {
        if (l == r) {
            if (expArr[l] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }
        int res = 0;
        if (desired) {
            for (int i = l + 1; i < r; i += 2) {
                switch (expArr[i]) {
                    case '&':
                        res += p(expArr, true, l, i - 1) * p(expArr, true, i + 1, r);
                        break;
                    case '|':
                        res += p(expArr, true, l, i - 1) * p(expArr, false, i + 1, r);
                        res += p(expArr, false, l, i - 1) * p(expArr, true, i + 1, r);
                        res += p(expArr, true, l, i - 1) * p(expArr, true, i + 1, r);
                        break;
                    case '^':
                        res += p(expArr, true, l, i - 1) * p(expArr, false, i + 1, r);
                        res += p(expArr, false, l, i - 1) * p(expArr, true, i + 1, r);
                        break;
                    default:
                        System.out.println();
                        break;
                }
            }
        } else {
            for (int i = l + 1; i < r; i += 2) {
                switch (expArr[i]) {
                    case '&':
                        res += p(expArr, false, l, i - 1) * p(expArr, true, i + 1, r);
                        res += p(expArr, true, l, i - 1) * p(expArr, false, i + 1, r);
                        res += p(expArr, false, l, i - 1) * p(expArr, false, i + 1, r);
                        break;
                    case '|':
                        res += p(expArr, false, l, i - 1) * p(expArr, false, i + 1, r);
                        break;
                    case '^':
                        res += p(expArr, true, l, i - 1) * p(expArr, true, i + 1, r);
                        res += p(expArr, false, l, i - 1) * p(expArr, false, i + 1, r);
                        break;
                    default:
                        System.out.println();
                        break;
                }
            }
        }
        return res;
    }

    public static int num2(String express, boolean desired) {
        if (null == express || "".equals(express)) {
            return 0;
        }
        char[] expArr = express.toCharArray();
        if (!isValid(expArr)) {
            return 0;
        }
        int[][] t = new int[expArr.length][expArr.length];
        int[][] f = new int[expArr.length][expArr.length];
        t[0][0] = (expArr[0] == '0') ? 0 : 1;
        f[0][0] = (expArr[0] == '1') ? 0 : 1;
        for (int i = 2; i < expArr.length; i += 2) {
            t[i][i] = (expArr[i] == '0') ? 0 : 1;
            f[i][i] = (expArr[i] == '1') ? 0 : 1;
            for (int j = i - 2; j >= 0; j -= 2) {
                for (int k = j; k < i; k += 2) {
                    if (expArr[k + 1] == '&') {
                        t[j][i] += t[j][k] * t[k + 2][i];
                        f[j][i] += (f[j][k] + t[j][k]) * f[k + 2][i] + f[j][k] * t[k + 2][i];
                    } else if (expArr[k + 1] == '|') {
                        t[j][i] += (f[j][k] + t[j][k]) * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i];
                    } else {
                        t[j][i] += f[j][k] * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i] + t[j][k] * t[k + 2][i];
                    }
                }
            }
        }
        return desired ? t[0][t.length - 1] : f[0][f.length - 1];
    }

    private static boolean isValid(char[] expArr) {
        if ((expArr.length & 1) == 0) {
            return false;
        }
        for (int i = 0; i < expArr.length; i = i + 2) {
            if ((expArr[i] != '1') && (expArr[i] != '0')) {
                return false;
            }
        }
        for (int i = 1; i < expArr.length; i = i + 2) {
            if ((expArr[i] != '&') && (expArr[i] != '|') && (expArr[i] != '^')) {
                return false;
            }
        }
        return true;
    }

}
