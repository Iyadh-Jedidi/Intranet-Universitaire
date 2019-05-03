/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import boundary.QuestionFacade;
import boundary.CommentFacade;
import java.util.ArrayList;

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


@Named(value = "commentController")
@RequestScoped
@ManagedBean(name = "commentController")
public class CommentController {
    @EJB
    
    private CommentFacade commentFacade;
    private Comment comment;
    
    public CommentController (){
        this.comment = new Comment ();
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
    
    
    public String postComment(Long idQuestion){
        this.comment.setIdQuesion(idQuestion);
        this.commentFacade.create(comment);
        return "index?faces-redirect=true";
        
    }
    public List selectCommentForPost(Long idPost){
        List comments= new ArrayList();
        for (int i = 0; i < commentFacade.findAll().size(); i++) {
            if (idPost == commentFacade.findAll().get(i).getIdQuesion()) {
                comments.add(commentFacade.findAll().get(i));
                
            }
        }
        return comments;
    }

}
