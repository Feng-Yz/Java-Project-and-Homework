package com.Yuzhen.ExerciseOnline.entity;

import javax.validation.constraints.NotBlank;

public class Subject {
    private int id;
    @NotBlank
    private String name;
    private String introduction;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
