package it.cspnet.ecommercespringmvc.web;

import it.cspnet.ecommercespringmvc.model.Carrello;
import it.cspnet.ecommercespringmvc.servizi.ServiziSitoECommerce;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EliminaVoceController {

    @Autowired
    private ServiziSitoECommerce servizi;

    public void setServizi(ServiziSitoECommerce servizi) {
        this.servizi = servizi;
    }

    @RequestMapping(value = "/eliminaVoce", method = RequestMethod.GET)
    public String eliminaVoce(HttpServletRequest req) {
        String idProdotto = req.getParameter("idProdotto");
        Carrello carrello = (Carrello) req.getSession().getAttribute("carrello");
        carrello.aggiornaVoce(servizi.cercaProdotto(idProdotto), -1);
        return "forward:listaprodotti.aspx";
    }
}
