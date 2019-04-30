/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import boundary.PersonFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Person;

/**
 *
 * @author iyadh
 */

@Named(value = "loginController")
@RequestScoped
@ManagedBean(name = "loginController")
public class loginController {

    /**
     * Creates a new instance of loginController
     */
    @EJB
    private PersonFacade personFacade;
    private Person person;
    
    public Person getPerson(){
        return person;
    }
    public void setPerson(Person person) {
        this.person= person;
    }
    public loginController() {
        this.person=new Person();
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
            if (user.getName().equals("admin")){
                return "admin?faces-redirect=true";
 
            }else
                return "home?faces-redirect=true";
        } else {
            context.addMessage(null, new FacesMessage("Email ou mot passe est incorrect"));
            return "login";
        }

    }
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
    
}
