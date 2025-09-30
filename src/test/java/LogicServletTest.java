import controller.LogicServlet;
import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.QuestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

class LogicServletTest {

    private LogicServlet servlet;
    private QuestService questService;

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher dispatcher;

    @BeforeEach
    void initialize() {
        questService = new QuestService();
        questService.initQuest();

        servlet = new LogicServlet();
        servlet.setQuestService_forTest(questService);

        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        dispatcher = mock(RequestDispatcher.class);

        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/questPage.jsp")).thenReturn(dispatcher);
    }

    @Test
    void processRequest_shouldMoveToNextQuestion() throws Exception {
        when(request.getParameter("answerId")).thenReturn("11");

        servlet.process_doPost_forTest(request, response);

        verify(session).setAttribute(eq("currentQuestion"), any(Question.class));
        verify(dispatcher).forward(request, response);
    }
}
