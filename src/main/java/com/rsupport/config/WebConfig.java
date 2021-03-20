package com.rsupport.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.rsupport.config.security.SecurityConfig;


public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	private static int MAX_FILE_SIZE = 10 * 1024 * 1024;

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootConfig.class, SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		// TODO Auto-generated method stub
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		
        MultipartConfigElement multipartConfig = new MultipartConfigElement("tmp_upload", MAX_FILE_SIZE, MAX_FILE_SIZE, 0);
        registration.setMultipartConfig(multipartConfig);
		
	}

}
