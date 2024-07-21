package com.redline.database;

import com.redline.question.Question;

import java.util.ArrayList;
import java.util.List;

public class DataQuestions {
    private List<Question> listWords = new ArrayList<>();

//    public DataQuestions() {
//        listWords.add(new Question("apartment", "квартира"));
//        listWords.add(new Question("balcony", "балкон"));
//        listWords.add(new Question("bathroom", "ванная комната"));
//        listWords.add(new Question("bed", "кровать"));
//        listWords.add(new Question("blanket", "одеяло"));
//        listWords.add(new Question("cabinet", "шкаф"));
//        listWords.add(new Question("ceiling", "потолок"));
//        listWords.add(new Question("chair", "стул"));
//        listWords.add(new Question("coset", "шкаф"));
//        listWords.add(new Question("comb", "расческа"));
//    }

    public List<Question> getListWords() {
        return listWords;
    }

    public void setListWords(List<Question> listWords) {
        this.listWords = listWords;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Question word: listWords) {
            result.append(word.toString()).append("\n");
        }
        return "DataQuestions{\n" +
                result +
                '}';
    }
}
