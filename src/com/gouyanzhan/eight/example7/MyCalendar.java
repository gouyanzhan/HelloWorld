package com.gouyanzhan.eight.example7;

/**
 * @author Yanzhan Gou
 * @date 2019-08-05 15:08:35
 */
//public class MyCalendar {
//    public static void main(String[] args){
//        GregorianCalendar now = new GregorianCadar();
//        //获得一个Date对象
//        Date date = new Date();
//        //打印出date
//        System.out.println(date.toString());
//        //用date设置 now 的时间
//        now.setTime(date);
//        //从now中取出当前的日期、月份
//        int today = now.get(Calendar.DAY_OF_MONTH);
//        int month = now.get(Calendar.MONTH);
//        //设置now的日期设为1
//        now.set(Calendar.DAY_OF_MONTH,1);
//        //得到 now 是一周的第几天
//        int week = now.get(Calendar.DAY_OF_WEEK);
//        //打印出日历头
//        System.out.println("Sun  Mon  Tue  Wed  Thu  Fri  Sat");
//        //打印出前面的空格
//        for (int i = Calendar.SUNDAY;i < week;i++){
//            System.out.println("        ");
//        }
//        while (now.get(Calendar.MONTH) == month){
//            int day = now.get(Calendar.DAY_OF_MONTH);
//            //为了对齐要对大于10和小于10的数字打印不同空格数
//            if (day < 10){
//                if (day == today){
//                    System.out.println("-" + day + "-  ");
//                }
//                else{
//                    System.out.println("  "+day+"  ");
//                }}
//            else{
//                 if (day == today){
//                     System.out.println("-" + day + "-  ");
//                 }else{
//                     System.out.println(" "+ day + "  ");
//                 }
//                }
//                //周六换行
//            if (week == Calendar.SATURDAY){
//                System.out.println();
//            }
//            //增加一天
//            now.add(Calendar.DAY_OF_MONTH,1);
//            week = now.get(Calendar.DAY_OF_WEEK);
//
//        }
//    }
//
//}
