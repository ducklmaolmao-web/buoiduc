package Onthi.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "StudentAttendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AttendanceID")
    private Integer attendanceId;

    @Column(name = "StudentName", length = 100)
    private String studentName;

    @Column(name = "ClassDate")
    private LocalDate classDate;

    @Column (name = "status")
    @Enumerated(EnumType.STRING)
    private AttendanceStatus diemDanhStatus;

    // Getters and Setters

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public LocalDate getClassDate() {
        return classDate;
    }

    public void setClassDate(LocalDate classDate) {
        this.classDate = classDate;
    }

    public AttendanceStatus getDiemDanhStatus() {
        return diemDanhStatus;
    }

    public void setDiemDanhStatus(AttendanceStatus diemDanhStatus) {
        this.diemDanhStatus = diemDanhStatus;
    }
}
