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
import javax.faces.bean.ManagedBean;
import model.Person;

/**
 *
 * @author iyadh
 */

@Named(value = "signUpController")
@RequestScoped
@ManagedBean(name = "signUpController")
public class SignUpController {
    @EJB
    private PersonFacade personFacade;
    private Person person;

    /**
     * Creates a new instance of SignUpController
     */
    public SignUpController() {
        this.person=new Person();
    }
    public Person getPerson(){
        return person;
    }
    public void setPerson(Person person) {
        this.person= person;
    }
    public String postPerson(){
        this.personFacade.create(person);
        return "home";
    }
    
    
}
