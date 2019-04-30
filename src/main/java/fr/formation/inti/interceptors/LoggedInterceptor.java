package fr.formation.inti.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fr.formation.inti.entities.Users;

public class LoggedInterceptor extends HandlerInterceptorAdapter  {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	RequestMapping method = ((HandlerMethod) handler).getMethodAnnotation(
                RequestMapping.class);
        long startTime = System.currentTimeMillis();
        System.out.println("\n-------- LogInterception.preHandle --- ");
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Start Time: " + System.currentTimeMillis());
        
 
        request.setAttribute("startTime", startTime);
        
        Users usr = (Users) request.getSession().getAttribute("user");
        
        System.out.println("Method: " + method.toString() +"  - - path: " + method.value()[0] + " - - " + (usr == null));
        if(usr == null)
        {
        	response.sendRedirect("/filterconnection");
        	return false;
        }
        
        return true;
        
        

 
        
    }

}

