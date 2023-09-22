package lk.ijse.gdse.globaltechapi.config;

import lk.ijse.gdse.globaltechapi.WebAppInitializer;
import lk.ijse.gdse.globaltechapi.api.TechLeadController;
import lk.ijse.gdse.globaltechapi.service.serviceImpl.TechLeadServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@Import(HibernateConfig.class)
@ComponentScan(basePackageClasses = {TechLeadController.class, WebAppInitializer.class, TechLeadServiceImpl.class}
)
public class WebAppConfig {
    public WebAppConfig() {
        System.out.println("web app config class");
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
