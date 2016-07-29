package com.global.yap.environment.injection.module;

import android.app.Application;
import android.content.Context;

import com.global.yap.environment.data.remote.NetworkService;
import com.squareup.otto.Bus;
import com.global.yap.environment.data.remote.NetworkServiceFactory;
import com.global.yap.environment.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies. Mainly singleton object that can be injected from
 * anywhere in the app.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    Bus provideEventBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    NetworkService provideEnvironmentService() {
        return NetworkServiceFactory.makeEnvironmentService();
    }

}