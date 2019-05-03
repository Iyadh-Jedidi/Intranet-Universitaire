/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import boundary.QuestionFacade;
import boundary.CommentFacade;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Question;
import model.Comment;



@Named(value = "questionController")
@RequestScoped
@ManagedBean(name = "questionController")
public class QuestionController {
    @EJB
    private QuestionFacade questionFacade;
    private CommentFacade commentFacade;
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
        this.questionFacade.create(question);
        return "index?faces-redirect=true";
    }
    
    public List showAll(){
        List<Question> questions = this.questionFacade.findAll();
        return questions;
    }
}
