package com.global.yap.environment.data.remote;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.global.yap.environment.EnvironmentApplication;
import com.global.yap.environment.data.model.base.BaseResponse;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import timber.log.Timber;

public class UnauthorisedInterceptor implements Interceptor {


    public UnauthorisedInterceptor(Context context) {
        EnvironmentApplication.get(context).getComponent().inject(this);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (response.code() != 200) {
            final BaseResponse baseResponse = new Gson().fromJson(response.body().string(), BaseResponse.class);
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
        return response;
    }
}
