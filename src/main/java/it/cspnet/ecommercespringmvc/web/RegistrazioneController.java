package it.cspnet.ecommercespringmvc.web;

import it.cspnet.ecommercespringmvc.model.Prodotto;
import it.cspnet.ecommercespringmvc.model.Utente;
import it.cspnet.ecommercespringmvc.servizi.ServiziSitoECommerce;
import it.cspnet.ecommercespringmvc.servizi.UtenteGiaEsistenteException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class RegistrazioneController {

    @Autowired
    private ServiziSitoECommerce servizi;

    public void setServizi(ServiziSitoECommerce servizi) {
        this.servizi = servizi;
    }

    @RequestMapping(value = "/registrazione", method = RequestMethod.GET)
    public String registrazione(@ModelAttribute("utente") Utente utente) {
        return "registrazione";
    }

    @RequestMapping(value = "/registrazione", method = RequestMethod.POST)
    public String registrazione(HttpServletRequest req, @Valid @ModelAttribute("utente") Utente utente, BindingResult result) throws UtenteGiaEsistenteException {

        RequestContext ctx=new RequestContext(req);
        
        
        utente.setProfilo("user");
        String messaggio = null;
        
        if (result.hasErrors()) {
            return "registrazione";
        }
        
        try {
            Utente utenteDB = servizi.registrazione(utente);
            String messageFromBundle=ctx.getMessage("registrazione.ok");
//            messaggio = "registrazione effettuata con successo";
            req.setAttribute("utentedb", utenteDB);
            return "index";
        } catch (UtenteGiaEsistenteException ex) {
            String messageFromBundle=ctx.getMessage("registrazione.error");
//            messaggio = "Username già usata ";
            req.setAttribute("messaggio", messageFromBundle);
            return "registrazione";
        }

    }
}
