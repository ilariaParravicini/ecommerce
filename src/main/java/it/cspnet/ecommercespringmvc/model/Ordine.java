package it.cspnet.ecommercespringmvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ordini")
public class Ordine implements Serializable{
    
    @Id
    @Column(name="id_ordine")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOrdine;
    
    @Column(name="data_ordine")
    private Date dataOrdine;   
    private float totale;
    @Column(length=20)
    private String statoOrdine="attivo";
    
    @ManyToOne
    private Utente utente;
    
    @OneToMany(mappedBy="ordine")
    private Set<LineaOrdine>linee=new HashSet<>();

    public Ordine() {
    }
    
    public Ordine(Date dataOrdine, Utente utente, float totale) {
       this.dataOrdine = dataOrdine;
       this.utente=utente;
       this.totale=totale;
    }
    
    public Ordine(int idOrdine, Date dataOrdine) {
        this.idOrdine = idOrdine;
        this.dataOrdine = dataOrdine;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Date getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public float getTotale() {
        return totale;
    }

    public void setTotale(float totale) {
        this.totale = totale;
    }

    public String getStatoOrdine() {
        return statoOrdine;
    }

    public void setStatoOrdine(String statoOrdine) {
        this.statoOrdine = statoOrdine;
    }

    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idOrdine;
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
        final Ordine other = (Ordine) obj;
        if (this.idOrdine != other.idOrdine) {
            return false;
        }
        return true;
    }
    
}
