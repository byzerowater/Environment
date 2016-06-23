package com.yapglobal.environment;

import android.app.Application;
import android.content.Context;

import com.yapglobal.environment.injection.component.ApplicationComponent;
import com.yapglobal.environment.injection.component.DaggerApplicationComponent;
import com.yapglobal.environment.injection.module.ApplicationModule;
import timber.log.Timber;

public class EnvironmentApplication extends Application  {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static EnvironmentApplication get(Context context) {
        return (EnvironmentApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}

