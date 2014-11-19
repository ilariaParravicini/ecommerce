package it.cspnet.ecommercespringmvc.web;

import it.cspnet.ecommercespringmvc.model.Prodotto;
import it.cspnet.ecommercespringmvc.servizi.ServiziSitoECommerce;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CercaProdottiController {
    
    @Autowired
    private ServiziSitoECommerce servizi;

    public void setServizi(ServiziSitoECommerce servizi) {
        this.servizi = servizi;
    }
    
    @RequestMapping(value="/ajax", method=RequestMethod.GET)
    //non ha molto senso fare @ModelAttribute perchè metodo è GET, passo solo pochi caratteri
    //e non è login
    public String nomeProdotto(HttpServletRequest req){
        List<Prodotto> prodotti=servizi.cercaProdotti(req.getParameter("nome"));
        req.setAttribute("prodotti", prodotti);
        return "infoprodotti";
    }
}
