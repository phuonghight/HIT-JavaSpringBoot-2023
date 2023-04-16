<<<<<<<< HEAD:week_03/src/main/java/com/example/week_03/ServletInitializer.java
package com.example.week_03;
========
package com.example.exercies05;
>>>>>>>> origin/exercise-05:exercies-05/src/main/java/com/example/exercies05/ServletInitializer.java

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
<<<<<<<< HEAD:week_03/src/main/java/com/example/week_03/ServletInitializer.java
        return application.sources(Week03Application.class);
========
        return application.sources(Exercies05Application.class);
>>>>>>>> origin/exercise-05:exercies-05/src/main/java/com/example/exercies05/ServletInitializer.java
    }

}
