<<<<<<<< HEAD:week-05/src/main/java/com/example/week05/ServletInitializer.java
package com.example.week05;
========
package com.example.week04;
>>>>>>>> origin/week-04:week-04/src/main/java/com/example/week04/ServletInitializer.java

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
<<<<<<<< HEAD:week-05/src/main/java/com/example/week05/ServletInitializer.java
        return application.sources(Week05Application.class);
========
        return application.sources(Week04Application.class);
>>>>>>>> origin/week-04:week-04/src/main/java/com/example/week04/ServletInitializer.java
    }

}
