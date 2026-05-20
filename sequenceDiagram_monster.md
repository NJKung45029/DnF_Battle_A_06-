sequenceDiagram
    actor 사용자 as 플레이어
    participant UI as Attack_Monster_UI
    participant Battle as 전투
    participant Player as 플레이어
    participant Character as 캐릭터
    participant Warrior as 전사
    participant Mage as 마법사

    사용자->>UI: 선택_몬스터공격()
    UI->>Battle: 몬스터공격(캐릭터)

    Battle->>Player: 플레이어체크(플레이어id)
    Player-->>Battle: boolean 반환

    alt 플레이어체크 실패
        Battle-->>UI: 몬스터공격 실패
        UI-->>사용자: 실패 메시지 출력
    else 캐릭터가 전사
        Battle->>Warrior: 스킬발동()
        Warrior-->>Battle: 검휘두르기 데미지 반환
        Battle->>Battle: 데미지 등급 판정
        Battle-->>UI: 몬스터공격 결과 반환
        UI-->>사용자: 공격 결과 출력
    else 캐릭터가 마법사
        Battle->>Mage: 스킬발동()
        Mage-->>Battle: 파이어볼 데미지 반환
        Battle->>Battle: 데미지 등급 판정
        Battle-->>UI: 몬스터공격 결과 반환
        UI-->>사용자: 공격 결과 출력
    end