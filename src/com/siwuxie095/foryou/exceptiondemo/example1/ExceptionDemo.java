package com.siwuxie095.foryou.exceptiondemo.example1;

/**
 * 异常总述
 *
 * @author Jiajing Li
 * @date 2019-10-25 17:35:33
 */
public class ExceptionDemo {

    /**
     * Throwable （可抛出的）下分为两类：
     * （1）Error：错误。是 Java 内部运行产生的错误，不可预知，不能被程序本身处理，不用人为处理。比如：OutOfMemoryError（内存溢出）
     * （2）Exception：异常。Java 程序运行过程中产生的异常。可预知，可以被程序本身处理。需要人为处理。
     *
     * Exception 分为两类：
     * （1）unchecked Exception：非检查异常（非受检异常）。即 无需检查的异常。一般都是运行时异常。
     * （2）checked Exception：检查异常（受检异常）。即 需要检查的异常。一般都是编译期异常。
     *
     *
     * 对于 unchecked Exception，不处理，编译期不会报错，但运行时可能报错：
     * RuntimeException 下的所有子类都是 unchecked Exception。
     * 常见的比如：
     * （1）NullPointerException（空指针异常）
     * （2）ArithmeticException（算术异常）
     * （3）ArrayIndexOutOfBoundsException（数组越界异常）
     * （4）ClassCastException（类型转换异常）
     * （5）...
     *
     * 对于 checked Exception，不处理，编译期就会报错，所以必须处理：
     * 常见的比如：
     * （1）IOException（输入输出异常）
     * （2）SQLException（SQL异常）
     * （3）FileNotFoundException（找不到文件异常）
     * （4）CloneNotSupportedException（不支持克隆异常）
     * （5）...
     */
    public static void main(String[] args) {
        
        uncheckedEx();
        
        checkedEx();

        System.out.println();
        System.out.println("最后，执行成功！！！");
    }

    private static void uncheckedEx() {
        //nullPointer();
        //arithmetic();
        arrayIndexOutOfBounds();
    }

    private static void nullPointer() {
        System.out.println("String str = null;");
        String str = null;
        System.out.println("str 的长度：" + str.length());
    }

    private static void arithmetic() {
        System.out.println("int i = 10 / 0;");
        int i = 10 / 0;
        System.out.println(i);
    }

    private static void arrayIndexOutOfBounds() {
        float[] arr = new float[] {1.0F, 2.0F, 3.0F};
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
    }


    private static void checkedEx() {
        fileNotFound();
    }

    private static void fileNotFound() {
        //File file = new File("123");
        //FileInputStream fis = new FileInputStream(file);
    }

}
