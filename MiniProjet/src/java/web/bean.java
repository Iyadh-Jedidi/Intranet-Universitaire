/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import static java.util.Collections.singleton;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author iyadh
 */

@Named("bean")
@Dependent
@ManagedBean(name="bean")
public class bean implements Serializable {
    private String email;
    private String pass;
    public boolean isLogged; 
    

    /**
     * Creates a new instance of bean
     */
  
    
    public bean() {
    }
    private String getEmail() {
        return email;
    }
    private void setEmail(String email) {
        this.email = email;
    }
    private String getPass() {
        return pass;
    }
    private void setPass(String pass) {
        this.pass = pass;
    }
    
    private String action(){
        isLogged=true; 
        return "forum.xhtml?faces-redirect=true ";
    }
    
}
