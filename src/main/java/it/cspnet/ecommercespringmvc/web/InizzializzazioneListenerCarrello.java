package it.cspnet.ecommercespringmvc.web;

import it.cspnet.ecommercespringmvc.model.Carrello;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class InizzializzazioneListenerCarrello implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        Carrello carrello=new Carrello();
        hse.getSession().setAttribute("carrello", carrello);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        
    }   
}
