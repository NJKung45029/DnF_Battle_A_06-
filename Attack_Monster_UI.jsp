<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="던전앤파이터전투.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Attack_Monster_UI</title>
</head>
<body>

<h2>몬스터공격</h2>

<form method="post">
    <input type="submit" name="공격" value="몬스터공격">
</form>

<hr>

<%
    request.setCharacterEncoding("UTF-8");

    String 공격 = request.getParameter("공격");

    if (공격 != null) {

        전투 전투객체 = (전투) session.getAttribute("전투객체");
        캐릭터 캐릭터객체 = (캐릭터) session.getAttribute("캐릭터객체");

        if (전투객체 == null || 캐릭터객체 == null) {
%>
            <h3>공격 실패</h3>
            <p>먼저 캐릭터를 생성해야 합니다.</p>
            <a href="Create_Character_UI.jsp">캐릭터생성 하러 가기</a>
<%
        } else {
            String 결과 = 전투객체.몬스터공격(캐릭터객체);
%>
            <h3>몬스터공격 결과</h3>
            <p><%= 결과 %></p>
<%
        }
    }
%>

<br><br>
<a href="index.jsp">메인으로</a>

</body>
</html>