/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import boundary.PersonFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Person;

/**
 *
 * @author iyadh
 */
@Named(value = "personneView")
@RequestScoped
@ManagedBean(name = "personView")

public class PersonView {

    @EJB
    private PersonFacade personFacade;
    private Person person;

    /**
     * Creates a new instance of PersonneView
     */
    public PersonView() {
        this.person=new Person();
    }
    public Person getPerson(){
        return person;
    }
    public void setPerson(Person person) {
        this.person= person;
    }
    
    
    public int getNumberOfPersonne(){
        return personFacade.findAll().size();
    }
    public String postPerson(){
        this.personFacade.create(person);
        return "home";
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
                return "admin";
            }else
                return "home";
        } else {
            return "login";
        }

    }
    
}
