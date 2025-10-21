package Onthi.servlet;

import Onthi.repo.AttendanceRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import Onthi.model.Attendance;
import Onthi.model.AttendanceStatus;

@WebServlet("/attendances/create")
public class CreateAttendanceServlet extends HttpServlet {
    private final AttendanceRepository repository = new AttendanceRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("studentName");

        String dateStr = req.getParameter("classDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            date = new Date(); // Nếu lỗi thì gán ngày hiện tại
        }

        String statusStr = req.getParameter("status");
        AttendanceStatus status = AttendanceStatus.valueOf(statusStr);

        Attendance attendance = new Attendance();
        attendance.setStudentName(name);
        attendance.setClassDate(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        attendance.setDiemDanhStatus(status);

        repository.create(attendance);

        resp.sendRedirect(req.getContextPath() + "/attendances");
    }
}
