package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.TraceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RaceInfo extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TraceDao traceDao = new TraceDao();
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        String id = request.getParameter("id");

        writer.println(new ObjectMapper().writeValueAsString(traceDao.getTraceById(Integer.parseInt(id))));
    }
}
