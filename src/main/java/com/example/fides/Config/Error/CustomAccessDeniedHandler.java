package com.example.fides.Config.Error;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception)
            throws IOException, ServletException {
                
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> errors = new HashMap<>();
            mapper.writeValue(response.getOutputStream(), errors);
        } catch (Exception e) {
            throw new ServletException();
        }
    }
    
}
