package com.ds.algo.facebook.leetcode;

public class Reader4 {

    public int read(char[] buf, int n) {
        int offset = 0;
        char[] buf4 = new char[4];
        while(true) {
            int count = read4(buf4);
            if (count == 0) {
                break;
            }
            for (int i = 0; i < count && offset < n; i ++) {
                buf[offset] = buf4[i];
                offset ++;
            }
        }
        return offset;
    }

    public int read4(char[] buf){
        return -1;
    }


}
