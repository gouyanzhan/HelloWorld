package com.siwuxie095.forme.algorithm.chapter5th.question1st.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-08 18:57:35
 */
public class Deformation {

    public static boolean isDeformation(String str1, String str2) {
        if (null == str1 || null == str2 || str1.length() != str2.length()) {
            return false;
        }
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < charArr1.length; ++i) {
            map[charArr1[i]]++;
        }
        for (int i = 0; i < charArr2.length; ++i) {
            if (map[charArr2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }


}
