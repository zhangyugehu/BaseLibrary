package com.thssh.library.faster.imageloader.delegate;

import android.widget.ImageView;

import com.thssh.library.faster.imageloader.IImageLoader;
import com.thssh.library.faster.imageloader.impl.GlideImageLoader;

/**
 * ImageLoader 代理类
 *
 * @author zhangyugehu
 * @version V1.0
 * @data 2017/08/04
 */

public class ImageLoader implements IImageLoader {

    interface Singleton{
        ImageLoader instance = new ImageLoader();
    }

    public static ImageLoader getInstance(){
        return Singleton.instance;
    }

    private ImageLoader(){
    }

    private IImageLoader mProcessor = new GlideImageLoader();

    public void setImageloader(IImageLoader loader){
        this.mProcessor = loader;
    }

    @Override
    public void setOptions(Options options){
        mProcessor.setOptions(options);
    }

    @Override
    public void loadImage(ImageView target, String path) {
        mProcessor.loadImage(target, path);
    }

}
