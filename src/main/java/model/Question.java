package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Question {
    private int id;
    private String question;
    private List<Answer> answers;

    @Override
    public String toString() {
        return question;
    }
}
