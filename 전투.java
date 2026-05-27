package 던전앤파이터전투;

public class 전투 {

    private 플레이어 플레이어객체;
    private String 플레이어id;
    private 캐릭터 현재캐릭터;
    private 길드 길드객체;

    public 전투() {
        this.플레이어객체 = new 플레이어();
        this.길드객체 = new 길드("던파길드");
    }

    public 캐릭터 캐릭터생성(String 플레이어id, String 캐릭터명, String 직업, int 레벨) {

        this.플레이어id = 플레이어id;

        if (!플레이어객체.플레이어체크(플레이어id)) {
            return null;
        }

        if ("전사".equals(직업)) {
            현재캐릭터 = new 전사(캐릭터명, 레벨);
        } else if ("마법사".equals(직업)) {
            현재캐릭터 = new 마법사(캐릭터명, 레벨);
        } else {
            return null;
        }

        return 현재캐릭터;
    }

    public String 몬스터공격(캐릭터 캐릭터) {

        if (!플레이어객체.플레이어체크(플레이어id)) {
            return "플레이어ID가 일치하지 않아 몬스터공격을 할 수 없습니다.";
        }

        if (캐릭터 == null) {
            return "생성된 캐릭터가 없습니다.";
        }

        int 데미지 = 캐릭터.스킬발동();
        String 스킬명 = 캐릭터.스킬명();

        String 등급;

        if (데미지 >= 200) {
            등급 = "S급 공격";
        } else if (데미지 >= 100) {
            등급 = "A급 공격";
        } else {
            등급 = "B급 공격";
        }

        return "캐릭터명: " + 캐릭터.get캐릭터명()
                + "<br>스킬명: " + 스킬명
                + "<br>데미지: " + 데미지
                + "<br>공격등급: " + 등급;
    }

    public String 아이템획득(캐릭터 캐릭터, String 아이템명, int 아이템가치) {

        if (!플레이어객체.플레이어체크(플레이어id)) {
            return "플레이어ID가 일치하지 않아 아이템획득을 할 수 없습니다.";
        }

        if (캐릭터 == null) {
            return "생성된 캐릭터가 없습니다.";
        }

        if (아이템명 == null || 아이템명.trim().isEmpty()) {
            return "아이템명을 입력해야 합니다.";
        }

        아이템 아이템객체 = new 아이템(아이템명, 아이템가치);
        캐릭터.get인벤토리객체().아이템추가(아이템객체);

        return "아이템획득 성공"
                + "<br>캐릭터명: " + 캐릭터.get캐릭터명()
                + "<br>아이템명: " + 아이템객체.get아이템명()
                + "<br>아이템등급: " + 아이템객체.get아이템등급()
                + "<br>아이템가치: " + 아이템객체.get아이템가치()
                + "<br>보유아이템수: " + 캐릭터.get인벤토리객체().get아이템목록().size();
    }

    public String 길드가입(캐릭터 캐릭터, String 길드명) {

        if (!플레이어객체.플레이어체크(플레이어id)) {
            return "플레이어ID가 일치하지 않아 길드가입을 할 수 없습니다.";
        }

        if (캐릭터 == null) {
            return "생성된 캐릭터가 없습니다.";
        }

        if (길드명 == null || 길드명.trim().isEmpty()) {
            return "길드명을 입력해야 합니다.";
        }

        if (!길드객체.get길드명().equals(길드명)) {
            길드객체 = new 길드(길드명);
        }

        boolean 가입결과 = 길드객체.캐릭터가입(캐릭터);

        if (!가입결과) {
            return "길드가입 실패"
                    + "<br>사유: 길드 정원이 가득 찼습니다."
                    + "<br>최대인원: " + 길드객체.get최대인원();
        }

        캐릭터.set길드객체(길드객체);

        return "길드가입 성공"
                + "<br>캐릭터명: " + 캐릭터.get캐릭터명()
                + "<br>길드명: " + 길드객체.get길드명()
                + "<br>현재인원: " + 길드객체.get현재인원()
                + "<br>최대인원: " + 길드객체.get최대인원();
    }

    public 캐릭터 get현재캐릭터() {
        return 현재캐릭터;
    }
}
