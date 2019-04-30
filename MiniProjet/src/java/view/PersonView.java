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
    
    public int getNumberOfPersonne(){
        return personFacade.findAll().size();
    }
    public String postPerson(){
        this.personFacade.create(person);
        return "home";
    }
    
}
