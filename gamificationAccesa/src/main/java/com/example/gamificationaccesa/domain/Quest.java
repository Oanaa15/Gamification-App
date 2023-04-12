package com.example.gamificationaccesa.domain;

import java.util.*;

public class Quest extends Entity{
    private String name;

    public Quest(Long id, String name, Long userid, String sentence, String answer) {
        super(id);
        this.name = name;
        this.userid = userid;
        this.sentence = sentence;
        this.answer = answer;
    }

    private Long userid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String sentence;

    private String answer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quest quest = (Quest) o;
        return Objects.equals(name, quest.name) && Objects.equals(userid, quest.userid) && Objects.equals(sentence, quest.sentence) && Objects.equals(answer, quest.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userid, sentence, answer);
    }

    @Override
    public String toString() {
        return "Quest{" +
                "name='" + name + '\'' +
                ", userid=" + userid +
                ", sentence='" + sentence + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
