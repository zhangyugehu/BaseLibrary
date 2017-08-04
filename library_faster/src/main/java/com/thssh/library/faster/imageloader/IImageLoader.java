package com.thssh.library.faster.imageloader;

import android.widget.ImageView;

/**
 * @author zhangyugehu
 * @version V1.0
 * @data 2017/08/04
 */

public interface IImageLoader {
    class Options {

    }

    void setOptions(Options options);

    void loadImage(ImageView target, String path);
}
