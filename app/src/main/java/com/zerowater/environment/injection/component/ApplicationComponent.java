package com.zerowater.environment.injection.component;

import android.app.Application;
import android.content.Context;

import com.zerowater.environment.data.DataManager;
import com.zerowater.environment.data.remote.ErrorInterceptor;
import com.zerowater.environment.data.remote.HeaderInterceptor;
import com.zerowater.environment.data.remote.NetworkService;
import com.zerowater.environment.injection.ApplicationContext;
import com.zerowater.environment.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(HeaderInterceptor headerInterceptor);
    void inject(ErrorInterceptor errorInterceptor);

    @ApplicationContext
    Context context();

    Application application();

    DataManager dataManager();

    NetworkService networkService();
}
