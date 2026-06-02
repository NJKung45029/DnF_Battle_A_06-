```mermaid
sequenceDiagram
    autonumber
    actor Player as 플레이어 (사용자)
    participant UI as Join_Guild_UI (JSP)
    participant Battle as 전투객체 (전투)
    participant Chk as 플레이어객체 (플레이어)
    participant Guild as 길드객체 (길드)
    participant Char as 캐릭터객체 (캐릭터)

    Player ->> UI: 가입할 길드명 입력
    
    note over UI: session.getAttribute() 실행<br/>보관소에서 캐릭터객체와 전투객체 참조 취득
    UI ->> Battle: 길드가입(캐릭터객체, 길드명) 호출
    
    %% 플레이어 체크
    Battle ->> Chk: 플레이어체크(플레이어id) 요청
    Chk -->> Battle: true 반환
    
    %% 길드 클래스 영역에서 정원 및 가입 제어
    Battle ->> Guild: 캐릭터가입(캐릭터객체) 호출
    Guild ->> Guild: 가입가능여부(캐릭터객체) 검증 (정원 5명 체크)
    
    alt 현재인원 < 5 (가입 가능)
        Guild ->> Guild: 캐릭터리스트.add(캐릭터객체)
        
        %% 연관 관계 설정을 위한 상호 참조 변경 구역
        Guild ->> Char: set길드(this) 호출 (캐릭터에 길드 저장)
        Guild -->> Battle: true 반환
        
        Battle -->> UI: "길드가입 성공" 결과 메시지 반환
    else 길드 정원 초과 (5명 이상)
        Guild -->> Battle: false 반환
        Battle -->> UI: "길드가입 실패 (정원 초과)" 메시지 반환
    end
    
    UI -->> Player: 길드가입 결과 화면 출력
