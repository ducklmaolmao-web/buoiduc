package Onthi.servlet;


import Onthi.model.Attendance;
import Onthi.repo.AttendanceRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/attendances")
public class DiemDanhServlet extends HttpServlet {
    private AttendanceRepository repo = new AttendanceRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Attendance> diemDanhs = repo.findAll();
        req.setAttribute("diemDanhs", diemDanhs);
        req.setAttribute("action", "listDiemDanhs");
        req.getRequestDispatcher("/Duh.jsp").forward(req, resp);
    }
}

