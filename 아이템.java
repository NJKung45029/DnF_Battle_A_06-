package 던전앤파이터전투;

public class 아이템 {

    private String 아이템명;
    private String 아이템등급;
    private int 아이템가치;

    public 아이템(String 아이템명, int 아이템가치) {
        this.아이템명 = 아이템명;
        this.아이템가치 = 아이템가치;
        this.아이템등급 = 등급부여(아이템가치);
    }

    private String 등급부여(int 아이템가치) {
        if (아이템가치 >= 1000) {
            return "전설";
        } else if (아이템가치 >= 500) {
            return "희귀";
        } else {
            return "일반";
        }
    }

    public String get아이템명() {
        return 아이템명;
    }

    public String get아이템등급() {
        return 아이템등급;
    }

    public int get아이템가치() {
        return 아이템가치;
    }

    @Override
    public String toString() {
        return "아이템명: " + 아이템명
                + ", 아이템등급: " + 아이템등급
                + ", 아이템가치: " + 아이템가치;
    }
}
