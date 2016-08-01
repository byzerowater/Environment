package com.global.yap.environment.injection.component;

import android.app.Application;
import android.content.Context;

import com.global.yap.environment.data.DataManager;
import com.global.yap.environment.data.remote.HeaderInterceptor;
import com.global.yap.environment.data.remote.NetworkService;
import com.global.yap.environment.data.remote.UnauthorisedInterceptor;
import com.global.yap.environment.injection.ApplicationContext;
import com.global.yap.environment.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(HeaderInterceptor headerInterceptor);
    void inject(UnauthorisedInterceptor unauthorisedInterceptor);

    @ApplicationContext
    Context context();

    Application application();

    DataManager dataManager();

    NetworkService networkService();
}
