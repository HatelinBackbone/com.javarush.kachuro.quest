package controller;

import model.Question;
import service.QuestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogicServlet", value = "/quest")
public class LogicServlet extends HttpServlet {

    QuestService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/questPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (service == null){
            service = (QuestService) getServletContext().getAttribute("questService");
        }

        String answerIdStr = req.getParameter("answerId");
        if (answerIdStr != null) {
            try {
                int answerId = Integer.parseInt(answerIdStr);

                Question nextQuestion = service.findNextQuestion(answerId);

                if (nextQuestion != null) {
                    session.setAttribute("currentQuestion", nextQuestion);
                } else {
                    session.removeAttribute("currentQuestion");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        req.getRequestDispatcher("/questPage.jsp").forward(req, resp);
    }

    public void process_doPost_forTest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void setQuestService_forTest(QuestService questService) {
        this.service = questService;
    }
}
