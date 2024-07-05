package jpabook.jpashop.domain;

import jakarta.persistence.Entity;

@Entity
public class Book extends Item{
    private String author;
    private String isbon;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbon() {
        return isbon;
    }

    public void setIsbon(String isbon) {
        this.isbon = isbon;
    }
}
