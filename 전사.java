package 던전앤파이터전투;

public class 전사 extends 캐릭터 {

    public 전사(String 캐릭터명, int 레벨) {
        super(캐릭터명, 레벨, 레벨 * 100, 레벨 * 15);
    }

    @Override
    public int 스킬발동() {
        return (int)(get공격력() * 1.5);
    }

    public String 스킬명() {
        return "검휘두르기";
    }
}