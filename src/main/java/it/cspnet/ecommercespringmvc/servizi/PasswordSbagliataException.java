/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cspnet.ecommercespringmvc.servizi;

/**
 *
 * @author CSP
 */
public class PasswordSbagliataException extends Exception {

    public PasswordSbagliataException() {
    }

    public PasswordSbagliataException(String message) {
        super(message);
    }

    public PasswordSbagliataException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordSbagliataException(Throwable cause) {
        super(cause);
    }

    public PasswordSbagliataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
