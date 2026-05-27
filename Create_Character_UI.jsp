<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="던전앤파이터전투.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create_Character_UI</title>
</head>
<body>

<h2>캐릭터생성</h2>

<form method="post">
    플레이어ID:
    <input type="text" name="플레이어id" required>
    <br><br>

    캐릭터명:
    <input type="text" name="캐릭터명" required>
    <br><br>

    직업:
    <select name="직업">
        <option value="전사">전사</option>
        <option value="마법사">마법사</option>
    </select>
    <br><br>

    레벨:
    <input type="number" name="레벨" required>
    <br><br>

    <input type="submit" value="캐릭터생성">
</form>

<hr>

<%
    request.setCharacterEncoding("UTF-8");

    String 플레이어id = request.getParameter("플레이어id");
    String 캐릭터명 = request.getParameter("캐릭터명");
    String 직업 = request.getParameter("직업");
    String 레벨문자 = request.getParameter("레벨");

    if (플레이어id != null && 캐릭터명 != null && 직업 != null && 레벨문자 != null) {

        int 레벨 = Integer.parseInt(레벨문자);

        전투 전투객체 = new 전투();
        캐릭터 캐릭터객체 = 전투객체.캐릭터생성(플레이어id, 캐릭터명, 직업, 레벨);

        if (캐릭터객체 == null) {
%>
            <h3>캐릭터생성 실패</h3>
            <p>플레이어ID는 반드시 hero여야 합니다.</p>
            <p>직업은 전사 또는 마법사만 가능합니다.</p>
<%
        } else {
            session.setAttribute("전투객체", 전투객체);
            session.setAttribute("캐릭터객체", 캐릭터객체);
            session.setAttribute("직업", 직업);
%>
            <h3>캐릭터생성 성공</h3>
            <p>플레이어ID: <%= 플레이어id %></p>
            <p>캐릭터명: <%= 캐릭터객체.get캐릭터명() %></p>
            <p>직업: <%= 직업 %></p>
            <p>레벨: <%= 캐릭터객체.get레벨() %></p>
            <p>HP: <%= 캐릭터객체.getHP() %></p>
            <p>공격력: <%= 캐릭터객체.get공격력() %></p>
            <p>길드: <%= 캐릭터객체.get길드명() %></p>
            <p>인벤토리: <%= 캐릭터객체.get인벤토리객체().get현재칸수() %> / <%= 캐릭터객체.get인벤토리객체().get최대칸수() %></p>

            <a href="Attack_Monster_UI.jsp">몬스터공격 하러 가기</a> |
            <a href="Get_Item_UI.jsp">아이템획득 하러 가기</a> |
            <a href="Join_Guild_UI.jsp">길드가입 하러 가기</a>
<%
        }
    }
%>

<br><br>
<a href="index.jsp">메인으로</a>

</body>
</html>