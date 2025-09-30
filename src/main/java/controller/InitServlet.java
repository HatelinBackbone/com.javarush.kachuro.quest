package controller;

import service.QuestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {

    @Override
    public void init() {
        QuestService service = new QuestService();
        service.initQuest();
        getServletContext().setAttribute("questService", service);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/startPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("playerName", req.getParameter("username"));

        QuestService service = (QuestService) getServletContext().getAttribute("questService");
        session.setAttribute("currentQuestion", service.getStartQuestion());

        getServletContext().getRequestDispatcher("/questPage.jsp").forward(req, resp);
    }
}
