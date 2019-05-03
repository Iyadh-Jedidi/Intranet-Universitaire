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
    private Comment comment;
    FacesContext context = FacesContext.getCurrentInstance();

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
    
    
    

    
    public QuestionController() {
        this.question=new Question();
        this.comment=new Comment();
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
    public String postComment(Long idQuestion){
        this.comment.setIdQuesion(idQuestion);
        this.commentFacade.create(comment);
        return "index?faces-redirect=true";
        
    }
    public List showAll(){
        List<Question> questions = this.questionFacade.findAll();
        return questions;
    }
}
