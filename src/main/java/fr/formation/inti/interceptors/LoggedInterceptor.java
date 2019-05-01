package fr.formation.inti.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fr.formation.inti.controllers.Signup_Controller;
import fr.formation.inti.entities.Users;

public class LoggedInterceptor extends HandlerInterceptorAdapter  {
	
	Logger logger = LoggerFactory.getLogger(LoggedInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	logger.info("fr.formation.inti.controllers.LoggedInterceptor.java - interceptor preHandle method");
    	RequestMapping method = ((HandlerMethod) handler).getMethodAnnotation(
                RequestMapping.class);
        long startTime = System.currentTimeMillis();
        
        logger.info("fr.formation.inti.controllers.LoggedInterceptor.java - interceptor preHandle method: Request URL: " + request.getRequestURL());
        logger.info("fr.formation.inti.controllers.LoggedInterceptor.java - interceptor preHandle method: Start Time: " + System.currentTimeMillis());

        request.setAttribute("startTime", startTime);
        
        Users usr = (Users) request.getSession().getAttribute("user");

        if(usr == null)
        {
        	logger.info("fr.formation.inti.controllers.LoggedInterceptor.java - interceptor preHandle method: user not found in session, redirect to filterconnection.html");
        	response.sendRedirect("/filterconnection");
        	return false;
        }
        
        return true;
        
        

 
        
    }

}

