package com.thssh.library.faster.service.http.impl;

import android.util.Pair;

import com.thssh.library.faster.service.http.IHttpClient;
import com.thssh.library.faster.utils.Logger;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author zhangyugehu
 * @version V1.0
 * @data 2017/08/04
 */

public class OkHttpClient implements IHttpClient {
    private static final String TAG = "OkHttpClient";

    static class ClientSingleton{
        static okhttp3.OkHttpClient instance;
        static{
            okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
            instance = builder.build();
        }
    }

    private okhttp3.OkHttpClient mClient;

    public OkHttpClient(){
        mClient = ClientSingleton.instance;
    }

    @Override
    public void get(String url, final Callback callback) {
        Logger.d(TAG, "get：" + url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = mClient.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(0, e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
            }
        });
    }

    @Override
    public void post(String url, Params params, final Callback callback) {
        Logger.d(TAG, "post：" + url);
        FormBody.Builder builder = new FormBody.Builder();
        if(params != null && params.maps != null) {
            for (Pair<String, String> pair : params.maps) {
                builder.add(pair.first, pair.second);
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        Call call = mClient.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(0, e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
            }
        });
    }
}
