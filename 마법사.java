package 던전앤파이터전투;

public class 마법사 extends 캐릭터 {

    public 마법사(String 캐릭터명, int 레벨) {
        super(캐릭터명, 레벨, 레벨 * 60, 레벨 * 25);
    }

    @Override
    public int 스킬발동() {
        return (int)(get공격력() * 2.0);
    }

    @Override
    public String 스킬명() {
        return "파이어볼";
    }
}