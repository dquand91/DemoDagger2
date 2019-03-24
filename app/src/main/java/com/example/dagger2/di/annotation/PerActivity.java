package com.example.dagger2.di.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


//Annotation @Scope để chỉ ra vùng tồn tại của các đối tượng được dagger cung cấp.
// Khi 1 class được Inject các dependency bởi Dagger, và các dependency đó được chỉ định @Scope,
// thì mỗi thể hiện của class đó sẽ được cung cấp các dependency khác nhau, độc lập và tồn tại trong vòng đời của class đó.

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
