/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cspnet.ecommercespringmvc.servizi;

/**
 *
 * @author corsojava
 */
public class UtenteGiaEsistenteException extends Exception {

    public UtenteGiaEsistenteException() {
    }

    public UtenteGiaEsistenteException(String message) {
        super(message);
    }

    public UtenteGiaEsistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public UtenteGiaEsistenteException(Throwable cause) {
        super(cause);
    }

    public UtenteGiaEsistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
