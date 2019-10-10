package com.siwuxie095.forme.designpattern.category.chapter3rd.example6th;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 将输入流内的所有大写字符转成小写字符（具体装饰者）
 *
 * @author Jiajing Li
 * @date 2019-10-10 15:52:54
 */
class LowerCaseInputStream extends FilterInputStream {

    LowerCaseInputStream(InputStream in) {
        super(in);
    }

    /**
     * 针对单个
     */
    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c : Character.toLowerCase((char) c);
    }

    /**
     * 针对数组
     */
    @Override
    public int read(byte[] b, int offset, int len) throws IOException {
        int result = super.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}
