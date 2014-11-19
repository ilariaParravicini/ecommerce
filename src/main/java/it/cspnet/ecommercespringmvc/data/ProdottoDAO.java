package it.cspnet.ecommercespringmvc.data;

import it.cspnet.ecommercespringmvc.model.Prodotto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("prodottoDao")
public interface ProdottoDAO extends JpaRepository<Prodotto, String>{

    public List<Prodotto> findByNomeStartingWith(String idProdotto);

}
