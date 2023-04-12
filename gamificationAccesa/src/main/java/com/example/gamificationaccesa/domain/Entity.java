package com.example.gamificationaccesa.domain;

public class Entity {
    public Entity(Long id) {
        this.id = id;
    }

    //private static final long serialVersionUID = 7331115341259248461L;
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}