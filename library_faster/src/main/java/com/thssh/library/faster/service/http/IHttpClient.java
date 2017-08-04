package com.thssh.library.faster.service.http;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyugehu
 * @version V1.0
 * @data 2017/08/04
 */

public interface IHttpClient {
    interface Callback{
        void onSuccess(String response);
        void onFailure(int code, String error);
    }

    class Params{
        public List<Pair<String, String>> maps;

        public Params() {
            maps = new ArrayList<>();
        }

        public Params create(String key, String value){
            return new Params().add(key, value);
        }

        public Params add(String key, String value){
            maps.add(Pair.create(key, value));
            return this;
        }
    }

    void get(String url, Callback callback);

    void post(String url, Params params, Callback callback);
}
