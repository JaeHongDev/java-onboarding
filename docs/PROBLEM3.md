## 🚀 기능 요구 사항

배달이가 좋아하는 369게임을 하고자 한다. 놀이법은 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 한다.

숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- number는 1 이상 10,000 이하인 자연수이다.

### 실행 결과 예시

| number | result |
| --- | --- |
| 13 | 4 |
| 33 | 14 |


# 요구사항 분석

- 369 게임을 하며 1부터 시작함
- 대신 3 6 9가 들어가는 숫자가 입력되면 손뼉을 쳐야함

# 도메인 별 기능 쪼개기

- 숫자
    - 3 6 9 가 들어가는 숫자가 존재하면 손뼉을 처야함
- 기록
    - 숫자의 카운트를 새줌

# 도메인 별 요구사항

- 숫자
    - [x]  3 6 9가 들어가는 숫자를 입력받으면 몇개가 들어가는지 갯수를 세고 반환함
- 기록
    - [x]  plus 메서드에 카운트를 집어넣으면 해당 값만큼 추가된다.