/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import boundary.QuestionFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Question;

@Named(value = "questionController")
@RequestScoped
@ManagedBean(name = "questionController")
public class QuestionController {
    @EJB
    private QuestionFacade questionFacade;
    private Question question;
    FacesContext context = FacesContext.getCurrentInstance();
    

    
    public QuestionController() {
        this.question=new Question();
    }
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    public String postQuestion(Long idUser){
        
        this.question.setIdUser(idUser);
        System.out.println(idUser);
        this.questionFacade.create(question);
        context.addMessage(null, new FacesMessage("Question posé"));
        return "home?faces-redirect=true";
    }
    public List showAll(){
        List<Question> questions = this.questionFacade.findAll();
        return questions;
    }
}
