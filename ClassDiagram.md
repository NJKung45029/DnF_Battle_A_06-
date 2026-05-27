```mermaid
classDiagram
    %% Boundary Classes (UI)
    class Create_Character_UI {
        <<boundary>>
        + 입력_플레이어ID(플레이어id: String)
        + 입력_캐릭터정보(캐릭터명: String, 직업: String, 레벨: int)
    }

    class Attack_Monster_UI {
        <<boundary>>
        + 선택_몬스터공격(입력id: String)
    }

    %% Core Classes
    class 플레이어ID {
        - id값: String
        + 플레이어ID(id값: String)
        + getId값() String
    }

    class 플레이어체크 {
        + 검증하기(원본id객체: 플레이어ID, 입력id: String) boolean
    }

    class 캐릭터 {
        <<abstract>>
        - 캐릭터명: String
        - 레벨: int
        - HP: int
        - 공격력: int
        + 스킬발동()* int
    }

    class 전사 {
        + 스킬발동() int
    }

    class 마법사 {
        + 스킬발동() int
    }

    class 전투 {
        + 캐릭터생성(입력id: String, 캐릭터명: String, 직업: String, 레벨: int) boolean
        + 몬스터공격(입력id: String, 대상ID: 플레이어ID, 체크모듈: 플레이어체크, 대상캐릭터: 캐릭터) String
    }

    %% Relationships
    %% 상속 관계 (전사, 마법사는 캐릭터를 상속)
    캐릭터 <|-- 전사
    캐릭터 <|-- 마법사

    %% UI Boundary와 전투 Control 간의 관계
    Create_Character_UI ..> 전투 : 사용
    Attack_Monster_UI ..> 전투 : 사용

    %% 전투 행위 중심의 의존 관계 (인자로 주고받음)
    전투 ..> 캐릭터 : 인자로 사용
    전투 ..> 플레이어ID : 인자로 사용
    전투 ..> 플레이어체크 : 인자로 사용
    
    %% 플레이어ID와 플레이어체크 간의 독립적 관계
    플레이어체크 ..> 플레이어ID : 검증을 위해 참조