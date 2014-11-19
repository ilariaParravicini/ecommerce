package it.cspnet.ecommercespringmvc.web;

import it.cspnet.ecommercespringmvc.model.Ordine;
import it.cspnet.ecommercespringmvc.model.Prodotto;
import it.cspnet.ecommercespringmvc.model.Utente;
import it.cspnet.ecommercespringmvc.servizi.ServiziSitoECommerce;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
public class ListaOrdiniController {

    @Autowired
    private ServiziSitoECommerce servizi;

    public void setServizi(ServiziSitoECommerce servizi) {
        this.servizi = servizi;
    }

    @RequestMapping(value = "/listaordini", method = RequestMethod.GET)
    public String listaOrdini(@ModelAttribute("ordine") Ordine ordine, HttpServletRequest req) {

        Utente utente = (Utente) req.getSession().getAttribute("utentedb");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -4);
        Date data = c.getTime();
        

        List<Ordine> ordini = servizi.listaOrdini(utente.getUserName(), data);
        req.setAttribute("ordini", ordini);
        return "ordini";
    }

}