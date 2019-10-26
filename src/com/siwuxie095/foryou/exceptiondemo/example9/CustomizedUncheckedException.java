package com.siwuxie095.foryou.exceptiondemo.example9;

/**
 * 自定义的非检查异常
 *
 * @author Jiajing Li
 * @date 2019-10-26 13:15:45
 */
class CustomizedUncheckedException extends RuntimeException {

    public CustomizedUncheckedException() {
    }

    public CustomizedUncheckedException(String message) {
        super(message);
    }
}
