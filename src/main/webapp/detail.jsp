<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chi tiết điểm danh</title>
</head>
<body>
<h1>Chi tiết điểm danh</h1>

<c:if test="${not empty attendance}">
    <p><strong>Attendance ID:</strong> ${attendance.attendanceId}</p>
    <p><strong>Student Name:</strong> ${attendance.studentName}</p>
    <p><strong>Class Date:</strong> ${attendance.classDate}</p>
    <p><strong>Status:</strong>
        <c:choose>
            <c:when test="${attendance.diemDanhStatus == 'Present'}">Có mặt</c:when>
            <c:when test="${attendance.diemDanhStatus == 'Absent'}">Vắng</c:when>
            <c:otherwise>Không rõ</c:otherwise>
        </c:choose>
    </p>
</c:if>

<p><a href="/attendances">⬅️ Quay lại danh sách</a></p>
</body>
</html>
