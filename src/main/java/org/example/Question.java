package org.example;



import java.util.ArrayList;
import java.util.List;

public class Question {
    private String text;
    private List<Answer> answers = new ArrayList<>();

    public Question(String text, List<Answer> answers) {
        this.text = text;
        this.answers = answers;
    }

    public Question()
    {}
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", answers=" + answers +
                '}';
    }
}