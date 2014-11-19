package it.cspnet.ecommercespringmvc.data;

import it.cspnet.ecommercespringmvc.model.LineaOrdine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("lineaOrdineDao")
public interface LineaOrdineDAO extends JpaRepository<LineaOrdine, Integer>{
      
}
