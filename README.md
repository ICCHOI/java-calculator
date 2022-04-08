# 자바 계산기 구현 미션

## 🥅 학습목표

> 깃허브를 통한 코드리뷰 경험
>
> 기본적인 테스트 코드 작성 및 활용하는 능력
>
> 스스로 OOP를 생각하고 코드를 옮길 수 있는 능력

## 🗒️ 요구사항

**객체지향적인 코드**로 계산기 구현하기

- [x]  더하기
- [x]  빼기
- [x]  곱하기
- [x]  나누기
- [x]  사칙연산의 우선순위
- [x]  테스트 코드 구현하기
- [x]  계산 이력을 맵으로 데이터 저장기능 만들기
- [x]  (선택) 정규식 사용

- 기대 실행 결과(콘솔) 및 실제 실행 결과

```java
1.조회
        2.계산

        선택:2

        1+2
        3

        1.조회
        2.계산

        선택:2

        1+2*3
        7

        1.조회
        2.계산

        선택:1

        1+2=3
        1+2*3=7

        선택:2

        3-2*2
        -1

```


## 🧑🏻‍💻 구현 내용


### 🧮 Double 자료형을 사용한 Double 사칙연산 계산기

### ➕ 계산기 구조

1. io package

- Input.java : 사용자 입력 interface 입니다.
- Output.java : 콘솔의 출력 interface 입니다.

2. model package

- Arithmetic.java : 사용자의 입력값을 검증 후 계산을 하기 위한 계산식으로 바꿔 저장하는 모델입니다.

3. repository package

- Repository.java: 저장소 interface 입니다.
- LogRepository.java: 사용자가 입력한 계산 기록에 관한 결과를 저장하는 저장소입니다.
    - Long 타입의 index를 Key 값으로 설정하여 계산 결과가 들어온 순서대로 저장할 수 있게 하였으며 HashMap으로 순서대로 들어온 계산식의 결과 값을 출력하도록 작성하였습니다.

4. utils package

- RegularExpression.java : 공통적으로 사용되는 정규표현식 함수들을 담은 클래스입니다.
- 음수값을 처리할 수 있게 정규표현식에 -도 처리할 수 있게 만들었습니다.

5. Calculation.java

- public Arithmetic toPostfix(Arithmetic arithmetic)
    - 입력값이 검증된 계산식을 덱을 사용하여 후위표기식으로 바꾸는 작업을 수행합니다.
- public Optional<Double> doCalculation(Arithmetic postfix)
    - 후위표기식으로 변환된 계산식을 받아 덱을 통해 계산을 수행한 후 Optional<Double>로 반환합니다.
    - 계산은 나누기 연산의 정확한 값을 표현하기 위하여 Double형을 사용하였습니다.
- public Optional<Double> calc (Double operandA, Double operandB, String Operator)
    - Double 형 피연산자 두 개와 연산자를 입력받아 해당 연산자의 결과를 Optional로 wrapping해 반환합니다.

6. Calculator.java

- 계산기의 기능적인 부분을 입력 케이스에 따라 수행할 로직을 담당합니다.
- 자료구조에 결과값을 저장하기 위한 arithmeticToString 함수를 작성하였습니다.

7. Validation.java

- 입력값이 유효한지 검사합니다.
- Split 함수를 사용해 blank space 하나를 기준으로 입력값을 나누었습니다.
- blank space 여러개로 구분 될 경우는 입력 실패로 간주하였습니다.
- flag를 사용하여 계산기의 특성상 피연산자과 연산자가 반복되어 입력되는 것을 확인하였습니다.

8. Console.java

- Input.java와 Output.java를 구현하여 입출력을 담당합니다.

## ✅ 피드백 반영사항

- 유틸성 클래스는 기본 생성자를 private으로 작성하라
- 지나친 Optional 사용을 지양해라

- 객체의 역할과 책임에 대하여 고려하라

- Test Case
    1. @DisplayName을 사용하였습니다.
    2. assertJ (assertThat)을 사용하였습니다.
    3. given - when - then 혹은 given - then 으로 구분하여 작성하였습니다.

- 명확하게 알아 볼수 있는 변수명으로 수정하였습니다.
- map을 static으로 수정하였습니다.
- Input, Output Interface를 제거하였습니다.
- 사용하지 않는 의존성을 삭제하였습니다.
- 구현체가 아닌 추상체를 선언하도록 바꾸었습니다.
- 내부에서 동작하는 필드를 private으로 선언하였습니다.
- static 필드로 case의 의미를 파악하기 쉽게 명시적으로 선언하였습니다.
- if / else 중첩문이 반복되는 부분을 method로 분리하였습니다.
- checkValidate 메서드 네이밍 변경
- String[] to ArrayList 변경
- Repository 테스트 케이스 작성
- output 메서드명 변경
- 불필요한 Optional 제거
- 종료 기능 추가

## ❓ PR 포인트 & 궁금한 점

1. 객체지향적 설계를 구현해 본 경험이 많이 부족해서, 강의의 숫자야구게임을 베이스로 설계하며 구현하였습니다. OOP적 설계를 위반하는 부분이 어떤 부분이 있는지 궁금합니다.
2. 테스트 케이스도 처음 사용하여 자료구조에 저장된 결과 값을 검증하는 부분을 구현하지 못하였는데 이 부분에 대한 테스트 케이스는 어떻게 작성해야하는지 궁금합니다.