package it.cspnet.ecommercespringmvc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="linee_ordine")
public class LineaOrdine implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLinea;
    
    @Column(name="quantita")
    private int quantita;
    
    @ManyToOne
    private Prodotto prodotto;
    
    @ManyToOne
    private Ordine ordine;

    public LineaOrdine() {
    }
    
    public LineaOrdine(int quantita, Ordine ordine, Prodotto  prodotto) {
        this.quantita = quantita;
        this.ordine = ordine;
        this.prodotto=prodotto;
    }   

    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idLinea;
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
        final LineaOrdine other = (LineaOrdine) obj;
        if (this.idLinea != other.idLinea) {
            return false;
        }
        return true;
    }
}
