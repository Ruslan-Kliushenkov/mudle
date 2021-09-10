package servlets;


import service.Race;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartRace extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String countOfHorse = request.getParameter("horses");
        String bet = request.getParameter("betOn");

        Race race = new Race();
        race.StartRace(Integer.parseInt(countOfHorse), bet);

        response.setStatus(201);
    }
}
