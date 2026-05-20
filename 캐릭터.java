package 던전앤파이터전투;

public abstract class 캐릭터 {

    private String 캐릭터명;
    private int 레벨;
    private int HP;
    private int 공격력;

    public 캐릭터(String 캐릭터명, int 레벨, int HP, int 공격력) {
        this.캐릭터명 = 캐릭터명;
        this.레벨 = 레벨;
        this.HP = HP;
        this.공격력 = 공격력;
    }

    public String get캐릭터명() {
        return 캐릭터명;
    }

    public int get레벨() {
        return 레벨;
    }

    public int getHP() {
        return HP;
    }

    public int get공격력() {
        return 공격력;
    }

    public abstract int 스킬발동();
}