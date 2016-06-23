package com.yapglobal.environment.injection.component;

import android.app.Application;
import android.content.Context;

import com.yapglobal.environment.data.DataManager;
import com.yapglobal.environment.data.remote.EnvironmentService;
import com.yapglobal.environment.injection.ApplicationContext;
import com.yapglobal.environment.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();
    Application application();
    DataManager dataManager();
    EnvironmentService environmentService();
}
