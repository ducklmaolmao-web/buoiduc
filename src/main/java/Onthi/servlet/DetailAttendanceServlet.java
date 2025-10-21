package Onthi.servlet;

import Onthi.model.Attendance;
import Onthi.repo.AttendanceRepository;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/attendances/detail")
public class DetailAttendanceServlet extends HttpServlet {
    private AttendanceRepository attendanceRepo = new AttendanceRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idRaw = req.getParameter("id");

        if (idRaw == null || idRaw.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thiếu tham số ID");
            return;
        }

        try {
            int id = Integer.parseInt(idRaw);
            Attendance attendance = attendanceRepo.findById(id);

            if (attendance != null) {
                req.setAttribute("attendance", attendance);
                req.getRequestDispatcher("/detail.jsp").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy dữ liệu");
            }

        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID không hợp lệ");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi máy chủ");
        }
    }
}
