package it.cspnet.ecommercespringmvc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="utenti")
public class Utente implements Serializable{
    
    @Id
    @Column(name="username", length=20)
    @NotEmpty
    private String userName;
    
    @Column(length=20)
    @NotEmpty
    private String password;
    @Column(length=20)
    private String profilo;

    @OneToMany(mappedBy="utente")
    private Set<Ordine> ordini = new HashSet<>();
    
    public Utente() {
        
    }
    
    public Utente(String userName, String password, String profilo) {
        this.userName = userName;
        this.password = password;
        this.profilo = profilo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilo() {
        return profilo;
    }

    public void setProfilo(String profilo) {
        this.profilo = profilo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utente other = (Utente) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }
    
    
    
}
