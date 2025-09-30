package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {
    private int id;
    private String answer;
    private int nextQuestionId;

    @Override
    public String toString() {
        return answer;
    }
}
