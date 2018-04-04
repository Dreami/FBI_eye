/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbi_eyePackages;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author maple
 */
public class counterFilter implements Filter {
    int visits;
    FilterConfig config;

    public void setFilterConfig(FilterConfig config) {
      this.config = config;
    }

    public FilterConfig getFilterConfig() {
      return config;
    }
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        ServletContext sc = getFilterConfig().getServletContext();
        visits = (int) sc.getAttribute("visits");
        visits++;
        sc.setAttribute("visits", visits);
        chain.doFilter(request, response);
    }
    public void destroy() {        
    }
    
    public void init(FilterConfig conf) throws ServletException {
        this.config = conf;
    }
}
