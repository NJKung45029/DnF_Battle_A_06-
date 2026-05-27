package 던전앤파이터전투;

import java.util.HashMap;
import java.util.Map;

public class 전투 {

    private 플레이어 플레이어객체;
    private String 플레이어id;
    private Map<String, 길드> 길드저장소;

    public 전투() {
        this.플레이어객체 = new 플레이어();
        this.길드저장소 = new HashMap<String, 길드>();
    }

    public 캐릭터 캐릭터생성(String 플레이어id, String 캐릭터명, String 직업, int 레벨) {

        this.플레이어id = 플레이어id;

        if (!플레이어객체.플레이어체크(플레이어id)) {
            return null;
        }

        if (레벨 <= 0) {
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

    public String 몬스터공격(캐릭터 캐릭터객체) {

        if (!플레이어객체.플레이어체크(플레이어id)) {
            return "플레이어ID가 일치하지 않아 몬스터공격을 할 수 없습니다.";
        }

        if (캐릭터객체 == null) {
            return "생성된 캐릭터가 없습니다.";
        }

        int 데미지 = 캐릭터객체.스킬발동();
        String 등급 = 데미지등급판정(데미지);

        return "캐릭터명: " + 캐릭터객체.get캐릭터명()
                + "<br>스킬명: " + 캐릭터객체.스킬명()
                + "<br>데미지: " + 데미지
                + "<br>공격등급: " + 등급;
    }

    public String 아이템획득(캐릭터 캐릭터객체, String 아이템명, String 아이템종류, int 아이템가치) {

        if (!플레이어객체.플레이어체크(플레이어id)) {
            return "플레이어ID가 일치하지 않아 아이템획득을 할 수 없습니다.";
        }

        if (캐릭터객체 == null) {
            return "생성된 캐릭터가 없습니다.";
        }

        if (아이템명 == null || 아이템명.trim().length() == 0) {
            return "아이템명을 입력해야 합니다.";
        }

        if (아이템종류 == null || 아이템종류.trim().length() == 0) {
            return "아이템종류를 입력해야 합니다.";
        }

        if (아이템가치 < 0) {
            return "아이템가치는 0 이상이어야 합니다.";
        }

        아이템 아이템객체 = new 아이템(아이템명, 아이템종류, 아이템가치);
        boolean 추가성공 = 캐릭터객체.get인벤토리객체().아이템추가(아이템객체);

        if (!추가성공) {
            return "인벤토리가 가득 차서 아이템을 획득할 수 없습니다.";
        }

        return "아이템획득 성공"
                + "<br>캐릭터명: " + 캐릭터객체.get캐릭터명()
                + "<br>획득 아이템: " + 아이템객체.toString()
                + "<br>현재 인벤토리: " + 캐릭터객체.get인벤토리객체().get현재칸수()
                + " / " + 캐릭터객체.get인벤토리객체().get최대칸수()
                + "<br><br>[인벤토리 목록]<br>" + 캐릭터객체.get인벤토리객체().아이템목록출력();
    }

    public String 길드가입(캐릭터 캐릭터객체, String 길드명) {

        if (!플레이어객체.플레이어체크(플레이어id)) {
            return "플레이어ID가 일치하지 않아 길드가입을 할 수 없습니다.";
        }

        if (캐릭터객체 == null) {
            return "생성된 캐릭터가 없습니다.";
        }

        if (길드명 == null || 길드명.trim().length() == 0) {
            return "길드명을 입력해야 합니다.";
        }

        길드명 = 길드명.trim();

        if (캐릭터객체.get길드객체() != null) {
            return "이미 " + 캐릭터객체.get길드명() + " 길드에 가입되어 있습니다.";
        }

        길드 길드객체 = 길드저장소.get(길드명);

        if (길드객체 == null) {
            길드객체 = new 길드(길드명);
            길드저장소.put(길드명, 길드객체);
        }

        boolean 가입성공 = 길드객체.길드가입(캐릭터객체);

        if (!가입성공) {
            return "길드 정원이 가득 차서 가입할 수 없습니다.";
        }

        return "길드가입 성공"
                + "<br>캐릭터명: " + 캐릭터객체.get캐릭터명()
                + "<br>길드명: " + 길드객체.get길드명()
                + "<br>현재 인원: " + 길드객체.get현재인원()
                + " / " + 길드객체.get최대인원()
                + "<br><br>[길드원 목록]<br>" + 길드객체.길드원목록출력();
    }

    private String 데미지등급판정(int 데미지) {
        if (데미지 >= 200) {
            return "S급 공격";
        } else if (데미지 >= 100) {
            return "A급 공격";
        } else {
            return "B급 공격";
        }
    }
}
