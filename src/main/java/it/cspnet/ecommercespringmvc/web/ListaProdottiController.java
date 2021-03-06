package it.cspnet.ecommercespringmvc.web;

import it.cspnet.ecommercespringmvc.model.Prodotto;
import it.cspnet.ecommercespringmvc.model.Utente;
import it.cspnet.ecommercespringmvc.servizi.ServiziSitoECommerce;
import java.io.IOException;
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
public class ListaProdottiController {

    @Autowired
    private ServiziSitoECommerce servizi;

    public void setServizi(ServiziSitoECommerce servizi) {
        this.servizi = servizi;
    }
    
     @RequestMapping(value="/listaprodotti", method=RequestMethod.GET)
     public String listaProdotti(@ModelAttribute("prodotto") Prodotto prodotto, HttpServletRequest req){
        List<Prodotto> prodotti=servizi.listaProdotti();
        req.setAttribute("prodotti", prodotti);
        return "listaprodotti";
    }


}
