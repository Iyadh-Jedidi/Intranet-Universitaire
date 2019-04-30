/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import model.Person;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import boundary.PersonFacade;

/**
 *
 * @author ASUS
 */
@Named(value = "loginMB")
@Dependent
public class loginMB {

   @EJB
private PersonFacade personFacade;
    public loginMB() {
    }
   public String userExists(String email, String password) {
        boolean b;
        b = false;
        Person user=null;
        FacesContext context = FacesContext.getCurrentInstance();
        for (int i = 0; i < personFacade.findAll().size(); i++) {
            if (email.equals(personFacade.findAll().get(i).getEmail()) && password.equals(personFacade.findAll().get(i).getPassword())) {
                b = true;
                user=personFacade.findAll().get(i);
            }
        }
        if (b) {
            context.getExternalContext().getSessionMap().put("user", user);
            return "home";
        } else {
            return "login";
        }

    } 
}
