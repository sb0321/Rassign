package com.rsupport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {"com.rsupport.controller", "com.rsupport.service"})
public class ServletConfig implements WebMvcConfigurer {
	
	private static final int MAX_FILE_SIZE = 10 * 1024 * 1024;

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		
		registry.viewResolver(bean);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	@Bean
    public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = 
        		new CommonsMultipartResolver();
        
        multipartResolver.setMaxUploadSize(MAX_FILE_SIZE);
        multipartResolver.setMaxUploadSizePerFile(MAX_FILE_SIZE);
        multipartResolver.setMaxInMemorySize(0);
        
        return multipartResolver;
    }

}
