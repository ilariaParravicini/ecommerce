package it.cspnet.ecommercespringmvc.data;

import it.cspnet.ecommercespringmvc.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("utenteDao")
public interface UtenteDAO extends JpaRepository<Utente, String>{
    
    public Utente findByUserNameAndPassword(String userName, String password);

}
