package com.Yuzhen.ExerciseOnline.entity;

import javax.validation.constraints.NotBlank;

public class Exercise {
    private int id;
    private int knowledge_id;
    @NotBlank
    private String subject_name;
    @NotBlank
    private String knowledge_name;
    private String content;
    private String answer;
    private Integer type;
    private Integer optNum;

    public Integer getOptNum() {
        return optNum;
    }

    public void setOptNum(Integer optNum) {
        this.optNum = optNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKnowledge_id() {
        return knowledge_id;
    }

    public void setKnowledge_id(int knowledge_id) {
        this.knowledge_id = knowledge_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getKnowledge_name() {
        return knowledge_name;
    }

    public void setKnowledge_name(String knowledge_name) {
        this.knowledge_name = knowledge_name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}