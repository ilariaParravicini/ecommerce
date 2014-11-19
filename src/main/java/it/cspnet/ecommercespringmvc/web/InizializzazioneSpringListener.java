package it.cspnet.ecommercespringmvc.web;

import it.cspnet.ecommercespringmvc.servizi.ServiziSitoECommerce;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InizializzazioneSpringListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServiziSitoECommerce servizi = (ServiziSitoECommerce) context.getBean("servizi");
        sce.getServletContext().setAttribute("servizi", servizi);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
