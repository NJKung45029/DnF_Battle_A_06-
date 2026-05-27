```mermaid
classDiagram
    %% Boundary 클래스 (UI 화면)
    class Add_item {
        <<boundary>>
        +요청_아이템획득()
    }
    class Join_Guild_UI {
        <<boundary>>
        +요청_길드가입()
    }

    %% Phase 1 재사용 및 제어 클래스
    class 플레이어 {
        -플레이어id: String
        +플레이어체크(플레이어id: String) boolean
    }

    class 캐릭터 {
        <<abstract>>
        -캐릭터명: String
        -레벨: int
        -HP: int
        -공격력: int
        -인벤토리: 인벤토리
        +스킬발동()* int
    }

    class 전사 {
        +스킬발동() int
    }

    class 마법사 {
        +스킬발동() int
    }

    class 전투 {
        -플레이어객체: 플레이어
        -플레이어id: String
        +캐릭터생성(플레이어id: String, 캐릭터명: String, 직업: String, 레벨: int) 캐릭터
        +몬스터공격(캐릭터객체: 캐릭터) String
        +아이템획득(플레이어id: String, 캐릭터객체: 캐릭터, 아이템명: String, 타입: String, 가치: int) String
        +길드가입(플레이어id: String, 캐릭터객체: 캐릭터, 길드객체: 길드) String
    }

    %% Phase 2 신규 클래스
    class 인벤토리 {
        -아이템리스트: List~아이템~
        -최대용량: int = 10
        +아이템추가(새아이템: 아이템) boolean
    }

    class 아이템 {
        -아이템명: String
        -타입: String
        -가치: int
        -등급: String
    }

    class 길드 {
        -길드명: String
        -캐릭터리스트: List~캐릭터~
        -최대인원: int = 5
        +캐릭터가입(캐릭터객체: 캐릭터) boolean
    }

    %% 상속 관계 (Inheritance)
    캐릭터 <|-- 전사 : 상속
    캐릭터 <|-- 마법사 : 상속

    %% 복합 관계 (Composition & Aggregation)
    캐릭터 "1" *--> "1" 인벤토리 : 인벤토리 (Composition)
    인벤토리 "1" *--> "*" 아이템 : 아이템리스트 (Composition 1:N)
    길드 "1" o--> "*" 캐릭터 : 캐릭터리스트 (Aggregation 1:N)

    %% UI Boundary 및 제어 클래스 간의 관계 (Dependency)
    Add_item ..> 전투 : 의존
    Join_Guild_UI ..> 전투 : 의존
    전투 "1" o--> "1" 플레이어 : 플레이어객체 소유
    전투 ..> 캐릭터 : 제어/참조
    전투 ..> 길드 : 제어/참조