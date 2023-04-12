package org.example;

public class Answer {
    private String text;
    private boolean isCorrect;

    public Answer(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public Answer(){}
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getisCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "text='" + text + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}