package 던전앤파이터전투;

public abstract class 캐릭터 {

    private String 캐릭터명;
    private int 레벨;
    private int HP;
    private int 공격력;

    // Composition: 캐릭터가 생성될 때 인벤토리도 함께 생성되고, 캐릭터가 보유한다.
    private 인벤토리 인벤토리객체;

    // Aggregation: 길드는 여러 캐릭터를 참조하지만, 캐릭터의 생명주기를 소유하지 않는다.
    private 길드 길드객체;

    public 캐릭터(String 캐릭터명, int 레벨, int HP, int 공격력) {
        this.캐릭터명 = 캐릭터명;
        this.레벨 = 레벨;
        this.HP = HP;
        this.공격력 = 공격력;
        this.인벤토리객체 = new 인벤토리();
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

    public 인벤토리 get인벤토리객체() {
        return 인벤토리객체;
    }

    public 길드 get길드객체() {
        return 길드객체;
    }

    public void set길드(길드 길드객체) {
        this.길드객체 = 길드객체;
    }

    public String get길드명() {
        if (길드객체 == null) {
            return "미가입";
        }

        return 길드객체.get길드명();
    }

    public abstract int 스킬발동();

    public abstract String 스킬명();
}
