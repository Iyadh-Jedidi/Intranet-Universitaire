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
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import model.Person;

/**
 *
 * @author iyadh
 */
@Named(value = "adminController")
@RequestScoped
@ManagedBean(name = "adminController")
public class adminController {
    @EJB
    private PersonFacade personFacade;
    private Person person;
    /**
     * Creates a new instance of adminController
     */
    public Person getPerson(){
        return person;
    }
    public void setPerson(Person person) {
        this.person= person;
    }
    public adminController() {
        this.person=new Person();
    }
    public String postPerson(){
        this.personFacade.create(person);
        return "viewComptes?faces-redirect=true";
    }
    public void delete(Person test){
        this.personFacade.remove(test);
        
    }

     public String edit(Person test){
        this.personFacade.edit(test);
        return "viewComptes?faces-redirect=true";
        
    }
    
}
