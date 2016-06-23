package com.yapglobal.environment.network;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yapglobal.environment.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YoungSoo Kim on 2016-06-22.
 * company Ltd
 * youngsoo.kim@yap.net
 * Retrofit 통신 모듈 네트워크 서비스
 */
public interface NetworkService {

    String BASE_URL = "baseurl";

    /**
     * Factory class that sets up a new ribot services
     */
    class Factory {

        public static NetworkService makeNetworkService(Context context) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                    : HttpLoggingInterceptor.Level.NONE);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //Rxandroid를 사용하기 위해 추가(옵션)
                    .addConverterFactory(GsonConverterFactory.create()) //Json Parser 추가
                    .build();

            return retrofit.create(NetworkService.class);
        }

    }
}
