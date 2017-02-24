package com.zerowater.environment.data.remote;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.zerowater.environment.EnvironmentApplication;
import com.zerowater.environment.data.model.base.BaseResponse;
import com.zerowater.environment.util.ToastManager;
import com.google.gson.Gson;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ErrorInterceptor implements Interceptor {

    @Inject
    ToastManager mToastManager;

    public ErrorInterceptor(Context context) {
        EnvironmentApplication.get(context).getComponent().inject(this);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        String bodyString = response.body().string();
        if (response.code() != 200) {
            final BaseResponse baseResponse = new Gson().fromJson(bodyString, BaseResponse.class);
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    mToastManager.showToast(baseResponse.getError());
                }
            });
        }
        return response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(), bodyString))
                .build();
    }
}
