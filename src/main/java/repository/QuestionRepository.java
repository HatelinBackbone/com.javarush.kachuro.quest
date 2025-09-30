package repository;

import model.Question;

import java.util.Collection;

public interface QuestionRepository{
    void save(Question question);
    Question findById(int id);
    Question findByAnswerId(int answerId);
    Collection<Question> findAll();
}
