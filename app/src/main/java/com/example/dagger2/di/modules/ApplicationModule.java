package com.example.dagger2.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.dagger2.MyApp;
import com.example.dagger2.di.annotation.DatabaseInfo;
import com.example.dagger2.di.annotation.MyApplicationContext;

import dagger.Module;
import dagger.Provides;

// Đây là bước rất quan trọng, ta sẽ xây dựng các module cung cấp các Dependency để sử dụng trong activity của ta

// Như bên constructor của class DBHelper cần 3 thành phần
//              @ApplicationContext Context và
//              @DatabaseInfo String và
//              @DatabaseInfo Integer.
//      Ở đây mình sẽ provide những cái đó cho Dagger biết thông qua phương thức:
//              "provideApplicationContext", provideDBName, provideDBVersion bên dưới
//               *** Nhớ là phải thêm @MyApplicationContext tương ứng với từng @Provides

@Module
public class ApplicationModule {

    MyApp application;

    public ApplicationModule(MyApp application) {
        this.application = application;
    }

    // Thêm @MyApplicationContext để Dagger biết mà trả đúng kiểu dữ liệu khi dúng @Provides
    @Provides
    @MyApplicationContext
    public Context provideApplicationContext() {
        return application;
    }

    @Provides
    @DatabaseInfo
    public String provideDBName() {
        return "DaggerExample-DB";
    }

    @Provides
    @DatabaseInfo
    public Integer provideDBVersion() {
        return 1;
    }


    // Ở đây không cần thêm custom Annotation như 3 cái provider trên, vì SharedPreferences này chỉ có 1 class mặc định duy nhât.
    // Nếu mình custom lại SharedPreferences hoặc có nhiều class SharedPreference thì mình phải tạo custom annotation để báo cho Dagger biết mà trả đúng kiểu dữ liệu khi dùng @Provider
    @Provides
    public SharedPreferences provideSharedPreference() {
        return application.getSharedPreferences("DaggerExample-SharedPrefs", Context.MODE_PRIVATE);
    }
}
