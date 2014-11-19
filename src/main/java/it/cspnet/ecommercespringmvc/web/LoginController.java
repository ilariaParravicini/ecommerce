package it.cspnet.ecommercespringmvc.web;

import it.cspnet.ecommercespringmvc.model.Prodotto;
import it.cspnet.ecommercespringmvc.model.Utente;
import it.cspnet.ecommercespringmvc.servizi.PasswordSbagliataException;
import it.cspnet.ecommercespringmvc.servizi.ServiziSitoECommerce;
import it.cspnet.ecommercespringmvc.servizi.UtenteInesistenteException;
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
public class LoginController {

    @Autowired
    private ServiziSitoECommerce servizi;

    public void setServizi(ServiziSitoECommerce servizi) {
        this.servizi = servizi;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String login(@ModelAttribute("utente") Utente utente) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest req, @Valid @ModelAttribute("utente") Utente utente, BindingResult result ) {

        RequestContext ctx= new RequestContext(req);
        String messageFromBundle= ctx.getMessage("login.error");
        String messaggio = null;
        if (result.hasErrors())
            return "index";
        Utente utenteDB=servizi.login(utente);
        if (utenteDB != null) {
            req.getSession().setAttribute("utentedb", utenteDB);
            return "home";
       } else {
           req.setAttribute("messaggio", messageFromBundle);
           return "index";
       }
//        try {
//            Utente utenteDB = servizi.login(utente);
//            req.getSession().setAttribute("utentedb", utente);
//            return "home";
//        } catch (UtenteInesistenteException ex) {
//            messaggio = "La userName non esiste";
//            req.setAttribute("messaggio", messaggio);
//            return "index";
//        } catch (PasswordSbagliataException ex) {
//            messaggio = "La password è sbagliata!";
//            req.setAttribute("messaggio", messaggio);
//            return "index";
//
//        } catch (Exception ex) {
//            messaggio = "";
//            req.setAttribute("messaggio", messaggio);
//            return "index";
//        }

    }
}
