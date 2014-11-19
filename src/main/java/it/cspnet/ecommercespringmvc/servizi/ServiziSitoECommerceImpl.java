package it.cspnet.ecommercespringmvc.servizi;

import it.cspnet.ecommercespringmvc.data.LineaOrdineDAO;
import it.cspnet.ecommercespringmvc.data.OrdineDAO;
import it.cspnet.ecommercespringmvc.data.ProdottoDAO;
import it.cspnet.ecommercespringmvc.data.UtenteDAO;
import it.cspnet.ecommercespringmvc.model.Carrello;
import it.cspnet.ecommercespringmvc.model.LineaOrdine;
import it.cspnet.ecommercespringmvc.model.Ordine;
import it.cspnet.ecommercespringmvc.model.Prodotto;
import it.cspnet.ecommercespringmvc.model.Utente;
import it.cspnet.ecommercespringmvc.model.VoceCarrello;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servizi")
@Transactional
public class ServiziSitoECommerceImpl implements ServiziSitoECommerce {

    @Autowired
    private ProdottoDAO prodottoDao;
    @Autowired
    private OrdineDAO ordineDao;
    @Autowired
    private LineaOrdineDAO lineaOrdineDao;
    @Autowired
    private UtenteDAO utenteDao;

    
    public void setProdottoDao(ProdottoDAO prodottoDao) {
        this.prodottoDao = prodottoDao;
    }

    public void setOrdineDao(OrdineDAO ordineDao) {
        this.ordineDao = ordineDao;
    }

    public void setLineaOrdineDao(LineaOrdineDAO lineaOrdineDao) {
        this.lineaOrdineDao = lineaOrdineDao;
    }

    public void setUtenteDao(UtenteDAO utenteDao) {
        this.utenteDao = utenteDao;
    }

    @Override
    public Utente registrazione(Utente utente) throws UtenteGiaEsistenteException{
        if (utenteDao.exists(utente.getUserName()))
            throw new UtenteGiaEsistenteException();
        return utenteDao.save(utente);             
    }

    @Override
    public Utente login(String userName, String password) throws UtenteInesistenteException, PasswordSbagliataException, Exception {
        try{
            Utente u = utenteDao.findOne(userName);
            if (!password.equals(u.getPassword()))
                throw new PasswordSbagliataException();
            return u;
        } catch (EmptyResultDataAccessException ex) {
            throw new UtenteInesistenteException();
        }
    }

    public List<Prodotto> listaProdotti() {
        return prodottoDao.findAll();
    }

    @Override
    public Prodotto cercaProdotto(String idProdotto) {
        return prodottoDao.findOne(idProdotto);
    }

    @Override
    public void acquista(Carrello carrello, Utente utente) {
        Ordine ordine = ordineDao.save(new Ordine(new Date(), utente, carrello.calcolaCosto()));
        for (VoceCarrello v : carrello.getVociCarrello()) {
            LineaOrdine linea = new LineaOrdine(v.getQuantita(), ordine, v.getProdotto());
            lineaOrdineDao.save(linea);
        }
    }

    @Override
    public List<Ordine> listaOrdini(String idUtente, Date data) {
        Utente utente = utenteDao.findOne(idUtente);
        return ordineDao.findByUtenteAndDataOrdineAfter(utente, data);
    }

    @Override
    public void annullaOrdine(int idOrdine) {
       Ordine ordineDaAnnullare = ordineDao.findOne(idOrdine);
       ordineDaAnnullare.setStatoOrdine("annullato");
       ordineDao.save(ordineDaAnnullare);
    }

    @Override
    public Ordine cercaOrdine(int idOrdine) {
        return ordineDao.findOne(idOrdine);
    }

    @Override
    public float valoreOrdini(Date data) {
        float totale = 0;
        List<Ordine> ordini;
        ordini = ordineDao.findByDataOrdineAfterAndStatoOrdineLike(data, "attivo");
        for (Ordine o : ordini) {
            totale += o.getTotale();
        }
        return totale;
    }

    @Override
    public Utente login(Utente utente) {
//throws UtenteInesistenteException, PasswordSbagliataException, Exception{
//        try{
            Utente u = utenteDao.findOne(utente.getUserName());
//            if (!utente.getPassword().equals(u.getPassword()))
//                throw new PasswordSbagliataException();
//            return u;
//        } catch (EmptyResultDataAccessException ex) {
//            throw new UtenteInesistenteException();
//        }
            return u;
    }

    @Override
    public List<Prodotto> cercaProdotti(String idProdotto) {
        return prodottoDao.findByNomeStartingWith(idProdotto);
    }

    @Override
    public List<Prodotto> cercaProdotti(Prodotto prodotto) {
        return prodottoDao.findByNomeStartingWith(prodotto.getNome());
    }
}
