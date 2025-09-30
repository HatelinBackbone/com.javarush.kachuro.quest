import constants.AppConstants;
import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.QuestService;

import static org.junit.jupiter.api.Assertions.*;

class QuestServiceTest {

    private QuestService questService;

    @BeforeEach
    void initialize() {
        questService = new QuestService();
        questService.initQuest();
    }

    @Test
    void shouldReturnFirstQuestion() {
        Question result = questService.getStartQuestion();
        assertNotNull(result);
        assertEquals(AppConstants.Quest1.Questions.QUESTION1, result.toString());
    }

    @Test
    void shouldReturnNextQuestionforCurrentAnswer() {
        Question result = questService.findNextQuestion(12);
        assertNotNull(result);
        assertEquals(2, result.getId());
    }

}
