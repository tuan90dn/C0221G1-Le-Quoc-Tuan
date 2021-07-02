package com.model.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Image implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mark;
    private String author;
    private String feedback;
    @Column(name = "like_comment")
    private int likeComment;
    @Column(name = "date_comment",columnDefinition = "DATE")
    private Date dateComment =new Date(System.currentTimeMillis());

    public Image() {
    }

    public Image(int mark, String author, String feedback, int likeComment, Date dateComment) {
        this.mark = mark;
        this.author = author;
        this.feedback = feedback;
        this.likeComment = likeComment;
        this.dateComment = dateComment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLikeComment() {
        return likeComment;
    }

    public void setLikeComment(int like) {
        this.likeComment = like;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date date) {
        this.dateComment = date;
    }
}
