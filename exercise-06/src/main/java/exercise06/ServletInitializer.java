<<<<<<<< HEAD:week-06/src/main/java/com/example/week06/ServletInitializer.java
package com.example.week06;
========
package exercise06;
>>>>>>>> origin/exercise-06:exercise-06/src/main/java/exercise06/ServletInitializer.java

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
<<<<<<<< HEAD:week-06/src/main/java/com/example/week06/ServletInitializer.java
        return application.sources(Week06Application.class);
========
        return application.sources(Exercise06Application.class);
>>>>>>>> origin/exercise-06:exercise-06/src/main/java/exercise06/ServletInitializer.java
    }

}
