package com.example.dagger2.di.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;


//Annotation @Qualifier nằm trong package javax.inject.
// Nó được sử dụng để phân biệt các đối tượng mà Dagger sẽ phân phối cho các lớp Dependency consumer.
// Ví dụ: 1 class có thể yêu cầu cung cấp cả ApplicationContext và ActivityContext.
// Trong khi 2 đối tượng này đều là thể hiện của lớp Context.
// Vậy ta cần 1 cái gì đó để giúp Dagger 2 phân biệt được 2 đối tượng này.
// Thứ ta cần chính là các @Qualifier annotation.
// Nó giúp Dagger 2 phân biệt được các đối tượng thuộc cùng 1 kiểu dữ liệu (trong trường hợp này là Context).

//*** Annotation @DatabseInfo để cung cấp thông tin về các thuộc tính để khởi tạo DBHelper. Các thuộc tính này là name và version.

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseInfo {
}
