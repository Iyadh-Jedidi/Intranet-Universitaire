/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import boundary.PersonFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Person;

/**
 *
 * @author iyadh
 */
@Named(value = "personView")
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
    
    
    public List getALL(){
        return personFacade.findAll();
        
    }
    public void delete(Person test){
        this.personFacade.remove(test);
    }
    
    
    
}
    

