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
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import boundary.PersonFacade;

/**
 *
 * @author ASUS
 */
@Table(name = "MEMBRE")
@XmlRootElement
@javax.faces.bean.ManagedBean(name = "MembreManager")
@RequestScoped
public class MemberManager {

    @EJB
    private PersonFacade personFacade;
    private Person person;


    public MemberManager() {
        this.person= new Person();
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
            return "AdminDashbord";
        } else {
            return "home";
        }

    }
               public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person= person;
    }
        }
      

    

