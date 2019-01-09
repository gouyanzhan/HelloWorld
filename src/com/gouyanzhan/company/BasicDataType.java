package com.gouyanzhan.company;

/**
 * 基本数据类型一共有八种,其对应的包装类型也有八种
 *
 * @author Yanzhan Gou
 * @date 2019-01-09 22:08:49
 */
    public class BasicDataType {
        public static void main(String[] args) {
            // 1
            int intVal = 1;
            // int对应的包装类型:Integer
            Integer boxedIntVal = 1;
            // 2
            short shortVal = 2;
            // short对应的包装类型:Short
            Short boxedShortVal = 2;
            // 3 推荐用L
            long longVal1 = 3;
            long longVal2 = 3L;
            long longVal3 = 3l;
            // long对应的包装类型：Long
            Long boxedLongVal = 3L;
            // 4
            byte byteVal = 4;
            // byte对应的包装类型：Byte
            Byte boxedByteVal = 4;
            // 5 推荐用F
            float floatVal1 = 5;
            float floatVal2 = 5F;
            float floatVal3 = 5f;
            // float对应的包装类型：Float
            Float boxedFloatVal = 5F;
            // 6 推荐用D
            double doubleVal1 = 6;
            double doubleVal2 = 6D;
            double doubleVal3 = 6d;
            // double对应的包装类型：Double
            Double boxedDoubleVal = 6D;
            // 7
            char charVal = 'h';
            // char对应的包装类型：Character
            Character boxedCharVal = 'h';
            // 8
            boolean booleanVal = true;
            // boolean对应的包装类型：Boolean
            Boolean boxedBooleanVal = false;



        }


}
