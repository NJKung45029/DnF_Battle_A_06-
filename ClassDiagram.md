classDiagram
    %% Boundary 클래스 (UI 화면)
    class Create_Character_UI {
        <<boundary>>
        +요청_캐릭터생성()
    }
    class Attack_Monster_UI {
        <<boundary>>
        +요청_몬스터공격()
    }
    class Add_item {
        <<boundary>>
        +요청_아이템획득()
    }
    class Join_Guild_UI {
        <<boundary>>
        +요청_길드가입()
    }

    %% Phase 1 재사용 클래스
    class 플레이어 {
        -String 플레이어id
        +플레이어체크(String id) boolean
    }

    class 캐릭터 {
        <<abstract>>
        -String 캐릭터명
        -int 레벨
        -int HP
        -int 공격력
        -인벤토리 인벤토리객체
        +스킬발동()* int
    }

    class 전사 {
        +스킬발동() int
    }

    class 마법사 {
        +스킬발동() int
    }

    class 전투 {
        -플레이어 플레이어객체
        -String 플레이어id
        +캐릭터생성(String id, String 명, String 직업, int 레벨) 캐릭터
        +몬스터공격(캐릭터 c) String
    }

    %% Phase 2 신규 클래스
    class 인벤토리 {
        -List~아이템~ 아이템리스트
        -int 최대용량 = 10
        +아이템추가(아이템 새아이템) boolean
    }

    class 아이템 {
        -String 아이템명
        -String 타입
        -int 가치
        -String 등급
    }

    class 길드 {
        -String 길드명
        -List~캐릭터~ 캐릭터리스트
        -int 최대인원 = 5
        +캐릭터타입() void
    }

    %% 상속 관계 (Inheritance)
    캐릭터 <|-- 전사 : 상속
    캐릭터 <|-- 마법사 : 상속

    %% 복합 관계 (Composition & Aggregation)
    캐릭터 "1" *--> "1" 인벤토리 : 인벤토리_합성화
    인벤토리 "1" *--> "*" 아이템 : 아이템리스트_1대N_합성화
    길드 "1" o--> "*" 캐릭터 : 캐릭터리스트_1대N_집단화

    %% UI Boundary 및 제어 클래스 간의 관계 (Dependency)
    Create_Character_UI ..> 전투 : 참조
    Attack_Monster_UI ..> 전투 : 참조
    Add_item ..> 전투 : 참조
    Join_Guild_UI ..> 전투 : 참조

    전투 "1" o--> "1" 플레이어 : 플레이어객체_소유
    전투 ..> 캐릭터 : 제어
    전투 ..> 길드 : 제어