package it.cspnet.ecommercespringmvc.data;

import it.cspnet.ecommercespringmvc.model.Ordine;
import it.cspnet.ecommercespringmvc.model.Utente;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ordineDao")
public interface OrdineDAO extends JpaRepository<Ordine, Integer>{
   
    public List<Ordine> findByUtenteAndDataOrdineAfter(Utente utente, Date data);

    public List<Ordine> findByDataOrdineAfterAndStatoOrdineLike(Date data, String attivo);
    
}
