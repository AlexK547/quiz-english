package com.redline.question;

public class Question {
    private String engWord;
    private String rusWord;
    private String category;

    public Question(String category, String engWord, String rusWord) {
        this.category = category;
        this.engWord = engWord;
        this.rusWord = rusWord;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEngWord() {
        return engWord;
    }

    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }

    public String getRusWord() {
        return rusWord;
    }

    public void setRusWord(String rusWord) {
        this.rusWord = rusWord;
    }

    @Override
    public String toString() {
        return "Question{" +
                "engWord='" + engWord + '\'' +
                ", rusWord='" + rusWord + '\'' +
                '}';
    }
}
