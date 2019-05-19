package com.siwuxie095.forme.test.test009;

/**
 * @author Jiajing Li
 * @date 2019-03-07 11:06:39
 */
public class Main {

    /**
     * 说明的问题：
     * 1、使用泛型 T 不需要做强制类型转换，而使用对象 Object 则需要做强制类型转换。
     * 2、使用泛型 T 在编译期更安全。因为在编译期就把问题给排除了，而使用对象 Object 则不能在编译期就保证没有任何问题。
     * 3、建议：通常情况下，参数和返回值都有时，使用泛型 T，参数有而返回值没有时，使用对象 Object。
     * 4、禁止：禁止在 Java 中使用泛型数组（虽然可以用，但不推荐）
     *
     * 参考链接：
     * 1、https://www.cnblogs.com/xujanus/p/8474553.html
     * 2、https://stackoverflow.com/questions/5207115/java-generics-t-vs-object
     * 3、https://blog.csdn.net/qq_22494029/article/details/79386607
     */
    public static void main(String[] args) {
        /*
         * 使用泛型 T 不需要做强制类型转换
         */
        String s1 = processT("s1");
        int i1 = processT(1);

        /*
         * 使用 Object 必须做强制类型转换
         */
        String s2 = (String) processObj("s2");
        int i2 = (int) processObj(1);
        // 运行时，将会抛类型转换异常 ClassCastException，但是在编译期却没有发现
        //int i3 = (int) processObj("i3");

        /*
         * 最好别这么用。不推荐使用泛型数组。
         */
        getT();

    }

    public static <T> T processT(T t) {
        return t;
    }

    public static Object processObj(Object obj) {
        return obj;
    }

    public static <T> T[] getT() {
        Object[] objArr = new Object[]{1, 2, 3};
        return (T[]) objArr;
    }

}
