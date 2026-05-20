```mermaid
classDiagram
    %% Boundary Classes
    class Create_Character_UI {
        <<boundary>>
        +입력_플레이어ID(플레이어id: String)
        +입력_캐릭터정보(캐릭터명: String, 직업: String, 레벨: int)
    }

    class Attack_Monster_UI {
        <<boundary>>
        +선택_몬스터공격()
    }

    %% Core Classes
    class 플레이어 {
        -플레이어id: String
        +플레이어체크(플레이어id: String) boolean
    }

    class 캐릭터 {
        <<abstract>>
        #캐릭터명: String
        #레벨: int
        #HP: int
        #공격력: int
        +스킬발동()* int
    }

    class 전사 {
        +스킬발동() int
    }

    class 마법사 {
        +스킬발동() int
    }

    class 전투 {
        +캐릭터생성(플레이어id: String, 캐릭터명: String, 직업: String, 레벨: int)
        +몬스터공격(캐릭터: 캐릭터) String
    }

    %% Relationships
    %% 상속 관계 (Inheritance / Extends 역할)
    캐릭터 <|-- 전사
    캐릭터 <|-- 마법사

    %% 연관 및 의존 관계 (Association & Dependency)
    Create_Character_UI ..> 전투 : 사용
    Attack_Monster_UI ..> 전투 : 사용
    전투 --> 플레이어 : 참조
    전투 --> 캐릭터 : 참조