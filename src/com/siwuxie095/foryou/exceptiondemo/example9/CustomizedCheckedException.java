package com.siwuxie095.foryou.exceptiondemo.example9;

/**
 * 自定义的检查异常
 *
 * @author Jiajing Li
 * @date 2019-10-26 13:15:45
 */
class CustomizedCheckedException extends Exception {

    public CustomizedCheckedException() {
    }

    public CustomizedCheckedException(String message) {
        super(message);
    }
}
