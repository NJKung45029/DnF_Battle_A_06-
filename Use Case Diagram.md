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

    %% include 관계 설정 표기 (HTML 엔티티 반영)
    UC1 -. "&lt;&lt;include&gt;&gt;" .-> UC3
    UC2 -. "&lt;&lt;include&gt;&gt;" .-> UC3