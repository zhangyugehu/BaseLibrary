package com.thssh.library.faster.imageloader.impl;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.thssh.library.faster.imageloader.IImageLoader;
import com.thssh.library.faster.utils.Logger;

/**
 * @author zhangyugehu
 * @version V1.0
 * @data 2017/08/04
 */

public class GlideImageLoader implements IImageLoader {
    private static final String TAG = "GlideImageLoader";

    @Override
    public void setOptions(Options options) {

    }

    @Override
    public void loadImage(ImageView target, String path) {
        Logger.d(TAG, "TODO : load " + path);
        Glide.with(target.getContext())
                .load(path)
                .into(target);
    }
}
