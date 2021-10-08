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

@WebServlet("/race/id")
public class RaceInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TraceDao traceDao = new TraceDao();
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        String id = request.getParameter("id");

        writer.println(new ObjectMapper().writeValueAsString(traceDao.getTraceById(Integer.parseInt(id))));
    }
}
