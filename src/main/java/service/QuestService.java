package service;

import constants.AppConstants;
import model.Answer;
import model.Quest;
import model.Question;
import repository.QuestFromConstants;
import repository.QuestRepository;
import repository.QuestionRepository;
import repository.QuestionsFromConstants;

import java.util.List;


public class QuestService {
    private final QuestRepository questRepository;
    private final QuestionRepository questionRepository;

    public QuestService() {
        this.questRepository = new QuestFromConstants();
        this.questionRepository = new QuestionsFromConstants();
    }

    public void initQuest() {
        Quest quest = new Quest(AppConstants.Quest1.QUEST_ID, List.of());

        Question question1 = new Question(
                1, AppConstants.Quest1.Questions.QUESTION1, List.of(
                new Answer(11, AppConstants.Quest1.Answers.ANSWER_11, AppConstants.Quest1.RESULT_ID_Q1),
                new Answer(12, AppConstants.Quest1.Answers.ANSWER_12, 2))
        );

        Question question2 = new Question(
                2, AppConstants.Quest1.Questions.QUESTION2, List.of(
                new Answer(21, AppConstants.Quest1.Answers.ANSWER_21, 3),
                new Answer(22, AppConstants.Quest1.Answers.ANSWER_22, AppConstants.Quest1.RESULT_ID_Q2))
        );

        Question question3 = new Question(
                3, AppConstants.Quest1.Questions.QUESTION3, List.of(
                new Answer(31, AppConstants.Quest1.Answers.ANSWER_31, AppConstants.Quest1.RESULT_ID_Q3_A1),
                new Answer(32, AppConstants.Quest1.Answers.ANSWER_32, AppConstants.Quest1.RESULT_ID_Q3_A2))
        );

        Question result_1 = new Question(AppConstants.Quest1.RESULT_ID_Q1, AppConstants.Quest1.Questions.ANSWER_11_RESULT, List.of());
        Question result_2 = new Question(AppConstants.Quest1.RESULT_ID_Q2, AppConstants.Quest1.Questions.ANSWER_22_RESULT, List.of());
        Question result_31 = new Question(AppConstants.Quest1.RESULT_ID_Q3_A1, AppConstants.Quest1.Questions.ANSWER_31_RESULT, List.of());
        Question result_32 = new Question(AppConstants.Quest1.RESULT_ID_Q3_A2, AppConstants.Quest1.Questions.ANSWER_32_RESULT, List.of());

        List.of(question1, question2, question3, result_1, result_2, result_31, result_32).forEach(questionRepository::save);

        quest.setQuestions(List.copyOf(questionRepository.findAll()));
        questRepository.save(quest);
    }

    public Question getStartQuestion(){
        return questionRepository.findById(1);
    }

    public Question findNextQuestion(int answerId){
        return questionRepository.findByAnswerId(answerId);
    }

    public Quest getQuestById(int id){
        return questRepository.findById(id);
    }
}
