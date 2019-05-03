package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Comment;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-03T14:16:31")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile SingularAttribute<Question, Long> idUser;
    public static volatile ListAttribute<Question, Comment> comments;
    public static volatile SingularAttribute<Question, String> question;
    public static volatile SingularAttribute<Question, Long> id;

}