package com.example.dagger2;

import android.app.Application;

import com.example.dagger2.data.DataManager;
import com.example.dagger2.di.components.ApplicationComponent;
import com.example.dagger2.di.components.DaggerApplicationComponent;
import com.example.dagger2.di.modules.ApplicationModule;

import javax.inject.Inject;


public class MyApp extends Application {

    ApplicationComponent applicationComponent;

    // Vì DataManager sẽ được tạo bởi Dagger, nên phải thêm @Inject vào để nó hiểu
    @Inject
    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
    }

    // Hàm này để khởi tạo Dagger và tiêm cái application vào Dagger
    // Sau khi chạy cái hàm này, thì dataManager sẽ được Dagger sinh ra, nên chỉ cần sử dụng thôi, ko cần quan tâm nó sống hay chết
    private void initApplicationComponent() {
        // DaggerApplicationComponent sẽ tự động sinh ra sau khi build project
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        applicationComponent.injectApplicationToDagger123(this);
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
