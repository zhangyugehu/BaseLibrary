package com.thssh.library.faster.utils;

import android.util.Log;

/**
 * @author zhangyugehu
 * @version V1.0
 * @data 2017/08/04
 */

public class Logger {

    private final static String TAG = "Logger";
    private static boolean mDebug = true;

    public static void debuger(boolean flag){
        mDebug = flag;
    }

    public static void d(String text){
        if(!mDebug) return;
        d(TAG, text);
    }

    public static void d(String tag, String text){
        if(!mDebug) return;
        Log.d(tag, text);
    }

    public static void e(String text, Throwable t){
        if(!mDebug) return;
        Log.e(TAG, text, t);
    }
}
