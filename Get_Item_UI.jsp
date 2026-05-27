<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="던전앤파이터전투.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Get_Item_UI</title>
</head>
<body>

<h2>아이템획득</h2>

<form method="post">
    아이템명:
    <input type="text" name="아이템명" required>
    <br><br>

    아이템종류:
    <select name="아이템종류">
        <option value="무기">무기</option>
        <option value="방어구">방어구</option>
        <option value="회복아이템">회복아이템</option>
        <option value="재료">재료</option>
    </select>
    <br><br>

    아이템가치:
    <input type="number" name="아이템가치" min="0" required>
    <br><br>

    <input type="submit" value="아이템획득">
</form>

<hr>

<%
    request.setCharacterEncoding("UTF-8");

    String 아이템명 = request.getParameter("아이템명");
    String 아이템종류 = request.getParameter("아이템종류");
    String 아이템가치문자 = request.getParameter("아이템가치");

    if (아이템명 != null && 아이템종류 != null && 아이템가치문자 != null) {

        전투 전투객체 = (전투) session.getAttribute("전투객체");
        캐릭터 캐릭터객체 = (캐릭터) session.getAttribute("캐릭터객체");

        if (전투객체 == null || 캐릭터객체 == null) {
%>
            <h3>아이템획득 실패</h3>
            <p>먼저 캐릭터를 생성해야 합니다.</p>
            <a href="Create_Character_UI.jsp">캐릭터생성 하러 가기</a>
<%
        } else {
            int 아이템가치 = Integer.parseInt(아이템가치문자);
            String 결과 = 전투객체.아이템획득(캐릭터객체, 아이템명, 아이템종류, 아이템가치);
%>
            <h3>아이템획득 결과</h3>
            <p><%= 결과 %></p>
<%
        }
    }
%>

<br><br>
<a href="index.jsp">메인으로</a>

</body>
</html>
