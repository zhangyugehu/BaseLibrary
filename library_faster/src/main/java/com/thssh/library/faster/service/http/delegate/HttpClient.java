package com.thssh.library.faster.service.http.delegate;

import com.thssh.library.faster.service.http.IHttpClient;
import com.thssh.library.faster.service.http.impl.OkHttpClient;

/**
 * @author zhangyugehu
 * @version V1.0
 * @data 2017/08/04
 */

public class HttpClient implements IHttpClient {
    private static final HttpClient ourInstance = new HttpClient();

    public static HttpClient getInstance() {
        return ourInstance;
    }

    private HttpClient() {
    }

    private IHttpClient mProcessor = new OkHttpClient();

    public void setClient(IHttpClient client){
        this.mProcessor = client;
    }

    @Override
    public void get(String url, Callback callback) {
        mProcessor.get(url, callback);
    }

    @Override
    public void post(String url, Params params, Callback callback) {
        mProcessor.post(url, params, callback);
    }
}
