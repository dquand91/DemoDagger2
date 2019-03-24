package com.example.dagger2.di.components;

import com.example.dagger2.MyApp;
import com.example.dagger2.data.DataManager;
import com.example.dagger2.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


// Đây là interface kết nối giữa Module và nơi sử dụng (DataManager)
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void injectApplicationToDagger123(MyApp myApp);

    DataManager getDataManager();
}
