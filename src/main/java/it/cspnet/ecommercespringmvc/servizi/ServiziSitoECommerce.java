/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cspnet.ecommercespringmvc.servizi;

import it.cspnet.ecommercespringmvc.model.Carrello;
import it.cspnet.ecommercespringmvc.model.Ordine;
import it.cspnet.ecommercespringmvc.model.Prodotto;
import it.cspnet.ecommercespringmvc.model.Utente;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author corsojava
 */
public interface ServiziSitoECommerce {
    
    public Utente registrazione(Utente utente) throws UtenteGiaEsistenteException;
    
    public Utente login(String userName, String password) throws UtenteInesistenteException, PasswordSbagliataException, Exception ; 
    
    public Prodotto cercaProdotto(String idProdotto);
    
    public List<Prodotto> listaProdotti();

    public void acquista(Carrello carrello, Utente utente);
    
    public List<Ordine> listaOrdini(String idUtente, Date data);

    public void annullaOrdine(int idOrdine);
    
    public float valoreOrdini(Date data);

    public Ordine cercaOrdine(int idOrdine);

    public Utente login(Utente utente); //throws UtenteInesistenteException, PasswordSbagliataException, Exception;

    public List<Prodotto> cercaProdotti(String idProdotto);

    public List<Prodotto> cercaProdotti(Prodotto prodotto);
}
