package lk.ijse.gdse.globaltechapiwithmaven.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = WebApplicationInitializer.class)
public class WebAppConfig {
    public WebAppConfig() {
        System.out.println("webAppCOnfig con");
    }
}
