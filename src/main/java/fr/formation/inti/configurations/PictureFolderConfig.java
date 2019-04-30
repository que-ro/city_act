package fr.formation.inti.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PictureFolderConfig implements WebMvcConfigurer{
	
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/project_pictures/**")
                .addResourceLocations("/static/pictures/projects");
    }

}
