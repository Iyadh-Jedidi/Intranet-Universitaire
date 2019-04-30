/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.bean;

/**
 *
 * @author iyadh
 */
public class loginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        bean session = (bean) req.getSession().getAttribute("bean");
        String url = req.getRequestURI();
        
        
        if (session == null || !session.isLogged ){
            if (url.indexOf("forum.xhtml") >=0 || url.indexOf("loout.xhtml")>=0){
                resp.sendRedirect((req.getServletContext().getContextPath()+"/login.xhtml"));
                
            }else{
                chain.doFilter(request,response);
            }
        }else{
            if (url.indexOf("register.xhtml") >=0 || url.indexOf("login.xhtml")>=0){
                resp.sendRedirect((req.getServletContext().getContextPath()+"/forum.xhtml"));
            }else if (url.indexOf("logout.xhtml") >=0) {
                req.getSession().removeAttribute("bean");
                resp.sendRedirect(req.getServletContext().getContextPath()+"/login.xhtml");
                
            }else{
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
