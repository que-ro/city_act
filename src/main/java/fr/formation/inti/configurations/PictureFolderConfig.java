package fr.formation.inti.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import fr.formation.inti.interceptors.LoggedInterceptor;

@Configuration
public class PictureFolderConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/project_pictures/**")
                .addResourceLocations("/static/pictures/projects");
    }
      
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // LogInterceptor apply to all URLs.
       registry.addInterceptor(new LoggedInterceptor())
       .addPathPatterns("/modifiermoncompte" , "/monprofilnv", "/signalementform_method", "/ambientpowerform_method", "/projetamenagementform_method", "/goto_projet_presentation/{id}/formap_post_comment", "/goto_signalement_presentation/{id}/formap_post_comment", "/goto_ambienpower_presentation/{id}/formap_post_comment", "/mesalertes");
 
    }


}
