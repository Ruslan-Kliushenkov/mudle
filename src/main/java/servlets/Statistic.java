package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.TraceDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/stats")
public class Statistic extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");

        TraceDao traceDao = new TraceDao();

        PrintWriter answer = resp.getWriter();

        answer.println(new ObjectMapper().writeValueAsString(traceDao.getTraces()));

    }

}
