package com.yapglobal.environment.data.remote;

import com.google.gson.Gson;
import com.yapglobal.environment.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.plugins.RxJavaErrorHandler;

/**
 * Provide "make" methods to create instances of {@link EnvironmentService}
 * and its related dependencies, such as OkHttpClient, Gson, etc.
 */

/**
 * Created by YoungSoo Kim on 2016-06-23.
 * company Ltd
 * youngsoo.kim@yap.net
 * Retrofit 통신 환경 설정
 */
public class EnvironmentServiceFactory {


    public static EnvironmentService makeEnvironmentService() {
        OkHttpClient okHttpClient = makeOkHttpClient(makeLoggingInterceptor(), makeHeaderInterceptor());
        return makeEnvironmentService(okHttpClient);
    }

    private static EnvironmentService makeEnvironmentService(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        return retrofit.create(EnvironmentService.class);
    }

    private static OkHttpClient makeOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Interceptor headerInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(headerInterceptor)
                .build();
    }

    private static HttpLoggingInterceptor makeLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);
        return logging;
    }

    private static Interceptor makeHeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("User-Agent", "Your-App-Name")
                        .header("Accept", "application/vnd.yourapi.v1.full+json")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }

        };
    }
}
