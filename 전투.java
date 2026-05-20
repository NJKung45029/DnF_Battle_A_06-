package 던전앤파이터전투;

public class 전투 {

    private 플레이어 플레이어객체;
    private String 플레이어id;

    public 전투() {
        this.플레이어객체 = new 플레이어();
    }

    public 캐릭터 캐릭터생성(String 플레이어id, String 캐릭터명, String 직업, int 레벨) {

        this.플레이어id = 플레이어id;

        if (!플레이어객체.플레이어체크(플레이어id)) {
            return null;
        }

        if ("전사".equals(직업)) {
            return new 전사(캐릭터명, 레벨);
        } else if ("마법사".equals(직업)) {
            return new 마법사(캐릭터명, 레벨);
        } else {
            return null;
        }
    }

    public String 몬스터공격(캐릭터 캐릭터) {

        if (!플레이어객체.플레이어체크(플레이어id)) {
            return "플레이어ID가 일치하지 않아 몬스터공격을 할 수 없습니다.";
        }

        if (캐릭터 == null) {
            return "생성된 캐릭터가 없습니다.";
        }

        int 데미지 = 캐릭터.스킬발동();

        String 스킬명 = "";

        if (캐릭터 instanceof 전사) {
            스킬명 = "검휘두르기";
        } else if (캐릭터 instanceof 마법사) {
            스킬명 = "파이어볼";
        }

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
}