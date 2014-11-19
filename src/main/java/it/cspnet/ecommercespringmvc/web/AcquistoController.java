package it.cspnet.ecommercespringmvc.web;

import it.cspnet.ecommercespringmvc.model.Carrello;
import it.cspnet.ecommercespringmvc.model.Utente;
import it.cspnet.ecommercespringmvc.servizi.ServiziSitoECommerce;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AcquistoController {

    @Autowired
    private ServiziSitoECommerce servizi;

    public void setServizi(ServiziSitoECommerce servizi) {
        this.servizi = servizi;
    }

    @RequestMapping(value = "/acquista", method = RequestMethod.GET)
    public String acquistoCarrello(HttpServletRequest req) {
        Carrello carrello = (Carrello) req.getSession().getAttribute("carrello");
        Utente utente = (Utente) req.getSession().getAttribute("utentedb");

        servizi.acquista(carrello, utente);
        carrello.svuota();
        req.setAttribute("messaggio", "Carrello acquistato! La merce Le verrà consegnata al più presto!");
        return "forward:listaprodotti.aspx";
    }
//   @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServiziSitoECommerce servizi = (ServiziSitoECommerce) getServletContext().getAttribute("servizi");
//        Carrello carrello = (Carrello) req.getSession().getAttribute("carrello");
//        Utente utente = (Utente) req.getSession().getAttribute("utente");
//        
//        servizi.acquista(carrello, utente);
//        carrello.svuota();
//        req.setAttribute("messaggio", "Carrello acquistato! La merce Le verrà consegnata al più presto!");
//        req.getRequestDispatcher("/user/listaprodotti.aspx").forward(req, resp);
//        
//    }

}
