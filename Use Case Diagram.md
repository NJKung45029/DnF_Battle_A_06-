```mermaid
graph LR
    %% Actor 정의
    Actor((플레이어))

    %% Use Case 정의
    UC1([캐릭터생성])
    UC2([몬스터공격])
    UC3([플레이어체크])

    %% 관계 설정 (의존 및 연관)
    Actor --> UC1
    Actor --> UC2

    UC1 -. "<<include>>" .-> UC3
    UC2 -. "<<include>>" .-> UC3

    %% 스타일링 (시각적 구분)
    style Actor fill:#f9f,stroke:#333,stroke-width:2px
    style UC1 fill:#e1f5fe,stroke:#03a9f4,stroke-width:2px
    style UC2 fill:#e1f5fe,stroke:#03a9f4,stroke-width:2px
    style UC3 fill:#fff3e0,stroke:#ff9800,stroke-width:2px