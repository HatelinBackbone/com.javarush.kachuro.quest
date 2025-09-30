package repository;

import model.Answer;
import model.Question;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class QuestionsFromConstants implements QuestionRepository{

    private final Map<Integer,Question> questions_repository = new HashMap<>();

    @Override
    public void save(Question question) {
        questions_repository.put(question.getId(), question);
    }

    @Override
    public Question findById(int id) {
        return questions_repository.get(id);
    }

    @Override
    public Question findByAnswerId(int answerId) {
        for (Question q : questions_repository.values()) {
                for (Answer a : q.getAnswers()) {
                    if (a.getId() == answerId) {
                        return findById(a.getNextQuestionId());
                    }
                }
        }
        return null;
    }

    @Override
    public Collection<Question> findAll() {
        return questions_repository.values();
    }
}
