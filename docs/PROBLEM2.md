## 🚀 기능 요구 사항

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"

임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |


# 문제2

# 요구사항 분석 및 정리

- 암호문을 입력 받음
- 중복된 문자열을 제거함
- 문자열에 중복된 값이 없을때까지 진행함

## 도메인 으로 쪼개기

- 평문
    - 어떤 문자열을 입력받더라도 문자열 내 중복된 문자열이 있는 경우 해당 문자열을 지웁니다.

## 기능 별 요구사항
1. [ ] 문자열을 입력 받을때 문자열이 몇개가 중복되더라도 지울 수 있어야한다.
2. [ ] 하나의 문자열이 입력되면 즉시 반환한다.