<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="던전앤파이터전투.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Join_Guild_UI</title>
</head>
<body>

<h2>길드가입</h2>

<form method="post">
    길드명:
    <input type="text" name="길드명" required>
    <br><br>

    <input type="submit" value="길드가입">
</form>

<hr>

<%
    request.setCharacterEncoding("UTF-8");

    String 길드명 = request.getParameter("길드명");

    if (길드명 != null) {

        전투 전투객체 = (전투) session.getAttribute("전투객체");
        캐릭터 캐릭터객체 = (캐릭터) session.getAttribute("캐릭터객체");

        if (전투객체 == null || 캐릭터객체 == null) {
%>
            <h3>길드가입 실패</h3>
            <p>먼저 캐릭터를 생성해야 합니다.</p>
            <a href="Create_Character_UI.jsp">캐릭터생성 하러 가기</a>
<%
        } else {
            String 결과 = 전투객체.길드가입(캐릭터객체, 길드명);
%>
            <h3>길드가입 결과</h3>
            <p><%= 결과 %></p>
<%
        }
    }
%>

<br><br>
<a href="index.jsp">메인으로</a>

</body>
</html>
