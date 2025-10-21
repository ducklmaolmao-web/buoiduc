package Onthi.servlet;

import Onthi.repo.AttendanceRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/attendances/delete")
public class DeleteAttendanceServlet extends HttpServlet {
    private final AttendanceRepository repository = new AttendanceRepository();

    @Override   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        try {
            Integer id = Integer.parseInt(idParam);
            boolean isDeleted = repository.deleteById(id);

            if (isDeleted) {
                resp.sendRedirect(req.getContextPath() + "/attendances");
            } else {
                resp.getWriter().println("❌ NOT FOUND ID: " + id);
            }
        } catch (NumberFormatException e) {
            resp.getWriter().println("❌ Invalid ID: " + idParam);
        }
    }
}
