```mermaid
sequenceDiagram
    autonumber
    actor Player as 플레이어 (사용자)
    participant UI as Add_Item_UI (JSP)
    participant Battle as 전투객체 (전투)
    participant Chk as 플레이어객체 (플레이어)
    participant Item as 아이템객체 (아이템)
    participant Char as 캐릭터객체 (캐릭터)
    participant Inv as 인벤토리객체 (인벤토리)

    Player ->> UI: 아이템 정보 입력 (아이템명, 아이템종류, 아이템가치)
    
    note over UI: session.getAttribute() 실행<br/>보관소에서 캐릭터객체와 전투객체 참조 취득
    UI ->> Battle: 아이템획득(캐릭터객체, 아이템명, 아이템종류, 아이템가치) 호출
    
    %% 플레이어 체크
    Battle ->> Chk: 플레이어체크(플레이어id) 요청
    Chk -->> Battle: true 반환
    
    %% 아이템 객체 생성 및 등급 부여
    Battle ->> Item: new 아이템(아이템명, 아이템가치) 생성
    Item ->> Item: 등급부여(아이템가치) 계산 (전설/희귀/일반)
    Item -->> Battle: 생성된 아이템객체 반환
    
    %% 캐릭터의 인벤토리에 추가 제어
    Battle ->> Char: get인벤토리객체() 요청
    Char -->> Battle: 인벤토리객체 반환
    
    Battle ->> Inv: 아이템추가(아이템객체) 호출
    
    alt 인벤토리 수량 < 10 (여유 있음)
        Inv ->> Inv: 아이템리스트.add(아이템객체)
        Inv -->> Battle: true 반환
        Battle -->> UI: "아이템획득 성공" 결과 메시지 반환
    else 인벤토리 가득 참 (10개 이상)
        Inv -->> Battle: false 반환
        Battle -->> UI: "아이템획득 실패" 메시지 반환
    end
    
    UI -->> Player: 아이템획득 결과 화면 출력
