package com.siwuxie095.forme.test.test015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Jiajing Li
 * @date 2019-10-21 11:23:46
 */
public class Main {

    /**
     * 说明的问题：
     * 1、虽然在 forEach 中无法使用 continue/break 语句，但是可以使用 return 作为替代。
     */
    public static void main(String[] args) {
        List<String> outerList = Arrays.asList("1", "2", "3", null, "4", "5");
        List<String> innerList = Arrays.asList("a", "b", "c", null, "d", "e");
        List<String> finalList = new ArrayList<>();
        outerList.forEach(outer ->
                innerList.forEach(inner -> {
                    if (Objects.isNull(outer) && Objects.isNull(inner)) {
                        return;
                    }
                    finalList.add(outer + inner);
                }));
        System.out.println(finalList);
    }
}
