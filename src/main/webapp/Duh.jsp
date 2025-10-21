<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách học sinh</title>
</head>
<body>
<h1>Danh sách học sinh</h1>

<!-- Form tạo mới Attendance -->
<form action="/attendances/create" method="post">
    <p>Student Name: <input type="text" name="studentName" required/></p>
    <p>Class Date: <input type="date" name="classDate" required/></p>
    <p>Status:
        <input type="radio" name="status" value="Present" required/>Present
        <input type="radio" name="status" value="Absent" required/>Absent
    </p>
    <p><input type="submit" value="Create"></p>
</form>

<!-- Bảng danh sách điểm danh -->
<c:if test="${not empty diemDanhs}">
    <table border="1">
        <thead>
        <tr>
            <th>Attendance ID</th>
            <th>Student Name</th>
            <th>Class Date</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${diemDanhs}" var="s">
            <tr>
                <td>${s.attendanceId}</td>
                <td>${s.studentName}</td>
                <td>${s.classDate}</td>
                <td>
                    <c:choose>
                        <c:when test="${s.diemDanhStatus == 'Present'}">Có mặt</c:when>
                        <c:when test="${s.diemDanhStatus == 'Absent'}">Vắng</c:when>
                        <c:otherwise>Không rõ</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="/attendances/detail?id=${s.attendanceId}">🔍 Detail</a> |
                    <a href="/attendances/delete?id=${s.attendanceId}" onclick="return confirm('Bạn có chắc muốn xoá không?');">🗑️ Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty diemDanhs}">
    <p>Không có dữ liệu điểm danh nào.</p>
</c:if>

</body>
</html>
