package lk.ijse.gdse.aad.globaltechnologyapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = lk.ijse.gdse.aad.globaltechnologyapi.WebAppInitializer.class)
public class WebAppConfig {
}
