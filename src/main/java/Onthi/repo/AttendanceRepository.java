package Onthi.repo;


import Onthi.ultil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Onthi.model.Attendance;


import java.util.List;

public class AttendanceRepository {

    public List<Attendance> findAll() {
        Session session = HibernateUtil.getSession();
        Query<Attendance> query = session.createQuery("FROM Attendance", Attendance.class);
        List<Attendance> attendances = query.getResultList();
        session.close();
        return attendances;
    }

    public boolean deleteById(Integer id) {
        boolean isSuccess = false;
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        // Tìm Attendance theo ID
        Query<Attendance> query = session.createQuery(
                "FROM Attendance a WHERE a.attendanceId = :id", Attendance.class);
        query.setParameter("id", id);
        Attendance attendance = query.uniqueResult();

        // Nếu tìm thấy thì xoá
        if (attendance != null) {
            session.remove(attendance);
            isSuccess = true;
        }

        transaction.commit();
        session.close();
        return isSuccess;
    }

    public void create(Attendance attendance) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(attendance);

        transaction.commit();
        session.close();
    }
    public Attendance findById(Integer id) {    
        Session session = HibernateUtil.getSession();
        Attendance attendance = session.find(Attendance.class, id);
        session.close();
        return attendance;
    }

    public void updateById(Integer id, Attendance attendance) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        attendance.setAttendanceId(id);
        session.merge(attendance);

        transaction.commit();
        session.close();
    }
}
