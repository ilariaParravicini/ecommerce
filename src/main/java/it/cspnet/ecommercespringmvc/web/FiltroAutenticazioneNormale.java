package it.cspnet.ecommercespringmvc.web;

import it.cspnet.ecommercespringmvc.model.Utente;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FiltroAutenticazioneNormale implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletRequest httpRequest =  ((HttpServletRequest)request);
       HttpServletResponse httpResponse = ((HttpServletResponse)response);
       
       HttpSession session = httpRequest.getSession();
       
       Utente utente = (Utente) session.getAttribute("utente");
       if (utente == null || !(utente.getProfilo().equals("user"))){
           httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.aspx");        
       }
       else
           // lascia passare la richiesta a chi c'è a valle
           chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
       
    }
    
}
