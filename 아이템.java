package 던전앤파이터전투;

public class 아이템 {

    private String 아이템명;
    private String 아이템종류;
    private int 아이템가치;

    public 아이템(String 아이템명, String 아이템종류, int 아이템가치) {
        this.아이템명 = 아이템명;
        this.아이템종류 = 아이템종류;
        this.아이템가치 = 아이템가치;
    }

    public String get아이템명() {
        return 아이템명;
    }

    public String get아이템종류() {
        return 아이템종류;
    }

    public int get아이템가치() {
        return 아이템가치;
    }

    @Override
    public String toString() {
        return 아이템명 + "(" + 아이템종류 + ", 가치: " + 아이템가치 + ")";
    }
}
