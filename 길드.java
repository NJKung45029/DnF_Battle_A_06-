package 던전앤파이터전투;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 길드 {

    private String 길드명;
    private static final int 최대인원 = 5;
    private List<캐릭터> 캐릭터리스트;

    public 길드(String 길드명) {
        this.길드명 = 길드명;
        this.캐릭터리스트 = new ArrayList<캐릭터>();
    }

    public String get길드명() {
        return 길드명;
    }

    public int get최대인원() {
        return 최대인원;
    }

    public int get현재인원() {
        return 캐릭터리스트.size();
    }

    public List<캐릭터> get캐릭터리스트() {
        return Collections.unmodifiableList(캐릭터리스트);
    }

    public boolean 가입가능여부(캐릭터 캐릭터객체) {
        if (캐릭터객체 == null) {
            return false;
        }

        if (캐릭터리스트.size() >= 최대인원) {
            return false;
        }

        return !캐릭터리스트.contains(캐릭터객체);
    }

    public boolean 길드가입(캐릭터 캐릭터객체) {
        if (!가입가능여부(캐릭터객체)) {
            return false;
        }

        캐릭터리스트.add(캐릭터객체);
        캐릭터객체.set길드(this);
        return true;
    }

    public String 길드원목록출력() {
        if (캐릭터리스트.isEmpty()) {
            return "가입한 길드원이 없습니다.";
        }

        StringBuilder 결과 = new StringBuilder();

        for (int i = 0; i < 캐릭터리스트.size(); i++) {
            캐릭터 캐릭터객체 = 캐릭터리스트.get(i);
            결과.append(i + 1)
                    .append(". ")
                    .append(캐릭터객체.get캐릭터명())
                    .append(" / 레벨: ")
                    .append(캐릭터객체.get레벨())
                    .append("<br>");
        }

        return 결과.toString();
    }
}
