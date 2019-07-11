package com.siwuxie095.forme.algorithm.chapter9th.question13th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-30 21:54:55
 */
public class Path {

    private static void pathsToDistances(int[] paths) {
        int cap = 0;
        for (int i = 0; i != paths.length; i++) {
            if (paths[i] == i) {
                cap = i;
            } else if (paths[i] > -1) {
                int curI = paths[i];
                paths[i] = -1;
                int preI = i;
                while (paths[curI] != curI) {
                    if (paths[curI] > -1) {
                        int next1 = paths[curI];
                        paths[curI] = preI;
                        preI = curI;
                        curI = next1;
                    } else {
                        break;
                    }
                }
                int value = paths[curI] == curI ? 0 : paths[curI];
                while (paths[preI] != -1) {
                    int lastPreI = paths[preI];
                    paths[preI] = --value;
                    curI = preI;
                    preI = lastPreI;
                }
                paths[preI] = --value;
            }
        }
        paths[cap] = 0;
    }

    private static void distancesToNums(int[] distances) {
        for (int i = 0; i != distances.length; i++) {
            int index = distances[i];
            if (index < 0) {
                // 重要
                distances[i] = 0;
                while (true) {
                    index = -index;
                    if (distances[index] > -1) {
                        distances[index]++;
                        break;
                    } else {
                        int nextIndex = distances[index];
                        distances[index] = 1;
                        index = nextIndex;
                    }
                }
            }
        }
        distances[0] = 1;
    }

    public static void pathsToNums(int[] paths) {
        if (null == paths || paths.length == 0) {
            return;
        }
        // citiesPath -> distances
        pathsToDistances(paths);
        // distances -> nums
        distancesToNums(paths);
    }


}
