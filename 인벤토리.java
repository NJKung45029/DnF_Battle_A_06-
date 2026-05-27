package 던전앤파이터전투;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 인벤토리 {

    private List<아이템> 아이템리스트;
    private int 최대칸수;

    public 인벤토리() {
        this.아이템리스트 = new ArrayList<아이템>();
        this.최대칸수 = 10;
    }

    public boolean 아이템추가(아이템 아이템객체) {
        if (아이템객체 == null) {
            return false;
        }

        if (아이템리스트.size() >= 최대칸수) {
            return false;
        }

        아이템리스트.add(아이템객체);
        return true;
    }

    public List<아이템> get아이템리스트() {
        return Collections.unmodifiableList(아이템리스트);
    }

    public int get현재칸수() {
        return 아이템리스트.size();
    }

    public int get최대칸수() {
        return 최대칸수;
    }

    public int get총아이템가치() {
        int 총가치 = 0;

        for (아이템 아이템객체 : 아이템리스트) {
            총가치 += 아이템객체.get아이템가치();
        }

        return 총가치;
    }

    public String 아이템목록출력() {
        if (아이템리스트.isEmpty()) {
            return "보유 아이템이 없습니다.";
        }

        StringBuilder 결과 = new StringBuilder();

        for (int i = 0; i < 아이템리스트.size(); i++) {
            아이템 아이템객체 = 아이템리스트.get(i);
            결과.append(i + 1)
                    .append(". ")
                    .append(아이템객체.get아이템명())
                    .append(" / 종류: ")
                    .append(아이템객체.get아이템종류())
                    .append(" / 가치: ")
                    .append(아이템객체.get아이템가치())
                    .append("<br>");
        }

        결과.append("총 아이템 가치: ").append(get총아이템가치());
        return 결과.toString();
    }
}
