package com.siwuxie095.forme.algorithm.chapter9th.question21th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-07-08 20:38:22
 */
public class Num {

    //region 英文表达

    public static String num1To19En(int num) {
        if (num < 1 || num > 19) {
            return "";
        }
        String[] nameArr = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ",
                "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ",
                "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        return nameArr[num - 1];
    }

    public static String num1To99En(int num) {
        if (num < 1 || num > 99) {
            return "";
        }
        if (num < 20) {
            return num1To19En(num);
        }
        int high = num / 10;
        String[] tyNameArr = {"Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ",
        "Seventy ", "Eighty ", "Ninety "};
        return tyNameArr[high - 2] + num1To19En(num % 10);
    }

    public static String num1To999En(int num) {
        if (num < 1 || num > 999) {
            return "";
        }
        if (num < 100) {
            return num1To99En(num);
        }
        int high = num / 100;
        return num1To19En(high) + "Hundred " + num1To99En(num % 100);
    }

    public static String getNumEnExp(int num) {
        if (num == 0) {
            return "Zero";
        }
        String res = "";
        if (num < 0) {
            res = "Negative, ";
        }
        if (num == Integer.MIN_VALUE) {
            res += "Two Billion, ";
            num %= -2_000_000_000;
        }
        num = Math.abs(num);
        int high = 1_000_000_000;
        int highIndex = 0;
        String[] nameArr = {"Billion ", "Million ", "Thousand ", ""};
        while (num != 0) {
            int cur = num / high;
            num %= high;
            if (cur != 0) {
                res += num1To999En(cur);
                res += nameArr[highIndex] + (num == 0 ? " " : ", ");
            }
            high /= 1000;
            highIndex++;
        }
        return res;
    }

    //endregion


    //region 中文表达

    public static String num1To9Zh(int num) {
        if (num < 1 || num > 9) {
            return "";
        }
        String[] nameArr = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};
        return nameArr[num - 1];
    }

    public static String num1To99Zh(int num, boolean hasBai) {
        if (num < 1 || num > 99) {
            return "";
        }
        if (num < 10) {
            return num1To9Zh(num);
        }
        int shi = num / 10;
        if (shi == 1 && (!hasBai)) {
            return "十" + num1To9Zh(num % 10);
        } else {
            return num1To9Zh(shi) + "十" + num1To9Zh(num % 10);
        }
    }

    public static String num1To999Zh(int num) {
        if (num < 1 || num > 999) {
            return "";
        }
        if (num < 100) {
            return num1To99Zh(num, false);
        }
        String res = num1To9Zh(num / 100) + "百";
        int rest = num % 100;
        if (rest == 0) {
            return res;
        } else if (rest >= 10) {
            res += num1To99Zh(rest, true);
        } else {
            res += "零" + num1To9Zh(rest);
        }
        return res;
    }

    public static String num1To9999Zh(int num) {
        if (num < 1 || num > 9999) {
            return "";
        }
        if (num < 1000) {
            return num1To999Zh(num);
        }
        String res = num1To9Zh(num / 1000) + "千";
        int rest = num % 1000;
        if (rest == 0) {
            return res;
        } else if (rest >= 100) {
            res += num1To999Zh(rest);
        } else {
            res += "零" + num1To99Zh(rest, false);
        }
        return res;
    }

    public static String num1To99999999Zh(int num) {
        if (num < 1 || num > 9999_9999) {
            return "";
        }
        int wan = num / 10000;
        int rest = num % 10000;
        if (wan == 0) {
            return num1To9999Zh(rest);
        }
        String res = num1To9999Zh(wan) + "万";
        if (rest == 0) {
            return res;
        } else {
            if (rest < 1000) {
                return res + "零" + num1To999Zh(rest);
            } else {
                return res + num1To9999Zh(rest);
            }
        }
    }

    public static String getNumZhExp(int num) {
        if (num == 0) {
            return "零";
        }
        String res = num < 0 ? "负" : "";
        int yi = Math.abs(num / 1_0000_0000);
        int rest = Math.abs(num % 1_0000_0000);
        if (yi == 0) {
            return res + num1To99999999Zh(rest);
        }
        res += num1To9999Zh(yi) + "亿";
        if (rest == 0) {
            return res;
        } else {
            if (rest < 1000_0000) {
                return res + "零" + num1To99999999Zh(rest);
            } else {
                return res + num1To99999999Zh(rest);
            }
        }
    }

    //endregion


}
