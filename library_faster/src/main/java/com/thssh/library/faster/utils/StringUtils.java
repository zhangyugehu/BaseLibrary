package com.thssh.library.faster.utils;

import android.text.TextUtils;

/**
 * @author zhangyugehu
 * @version V1.0
 * @data 2017/08/04
 */

public class StringUtils {

    /**
     * 某项不equal
     * @param dest
     * @param args
     * @return
     */
    public static boolean equalsOr(String dest, String... args){
        for(String arg:args){
            if(TextUtils.equals(dest, arg)){
                return true;
            }
        }
        return false;
    }

    /**
     * 全equal
     * @param dest
     * @param args
     * @return
     */
    public static boolean equalsAnd(String dest, String... args){
        for(String arg : args){
            if(!TextUtils.equals(dest, arg)){
                return false;
            }
        }
        return true;
    }
}
