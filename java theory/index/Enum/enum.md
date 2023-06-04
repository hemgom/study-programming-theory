# Enum 클래스?
- 직역하면 `열거(1)`라는 의미인 `enumeration`의 앞 글자를 딴 약어를 이름으로하는 `클래스`이다.
- 특정 목적이 있는 클래스 안에 목적과 연관이 있는 `상수`들을 모아 놓고 이를 활용한다.
- `enum` 키워드를 사용해 정의한 걸 `열거체` 또는 `enum`으로 표현하겠다.

## 왜 필요할까?
- 개발을 하다보면 여러 클래스에서 사용하는 데이터를 다루는 경우가 생긴다. 대게 이런 경우 `상수(2)`를 사용하게 된다.
- 하지만 시간이 지나면서 상수를 변경하는 여러 방법들이 생겨났다.
- 결국 상수의 근본적인 사용 이유에 대한 `보장`이 필요하게 되었고 이를 위해 나타난게 `Enum 클래스`이다.

## 구현 방법은?
### 1. 선언
```
public enum ExEnum {
    ONE,
    TWO,
    THREE;
}
```
- `enum` 키워드를 사용해 열거체(enum) `ExEnum`을 선언하였다.  
- 구현부에 상수명을 적어주면 해당 이름으로 상수가 선언된다.
  - 상수명은 묵시적으로 전부 `대문자`로 띄어쓰기는 `_`로 표기한다.
  - `ONE` = `static final ExEnum ee = new ExEnum("ONE");`
- 별도의 상수값을 지정하지 않을 경우 첫 번째 상수에 상수값 `0`이 저장된다.
  - 다음 상수들에는 순차적으로 `1`이 증가한 상수값이 저장된다.
### 2. 사용
```
import static 패키지경로.ExEnum.*;     // 작성자는 다른 패키지에 'enum'이 있기 때문에 

public class Main {
    public static void main(String[] args) {
        System.out.println(LEFT);
    }
}
```
- 출력 구문을 통해 상수 `LEFT`를 출력했다. 해당 경우 `상수명`이 출력된다.
### 3. 상수값 설정과 사용
```
public enum EX_enum {
    // 상수명 옆 '()' 안에 설정할 상수값을 추가한다.
    LEFT("왼쪽"),
    RIGHT("오른쪽");

    // 설정 할 상수값 저장을 위한 인스턴스 변수와 생성자 추가
    private final String message;
    EX_enum(String message) { this.message = message; }
    
    // 상수값 출력을 위한 메서드 구현
    public String printMessage() {
        return this.message;
    }
}
```
- 위 처럼 상수에 상수값을 지정할 경우 해당 값을 저장할 `인스턴스 변수`와 `생성자`가 필요하다.
- 열거체에 저장된 상수를 사용하기 위한 메서드 또한 열거체에 구현해준다.
```
import static 패키지경로.ExEnum.*;     // 작성자는 다른 패키지에 'enum'이 있기 때문에 

public class Main {
    public static void main(String[] args) {
        System.out.println(LEFT.printMessage());
    }
}
```
- `printMessage()`를 사용해 `상수값`을 반환받아 출력했다.

## Enum 클래스의 기본 메서드
1. `values()` : 열거체(enum)에 열거된 상수를 순차적으로 배열에 저장해 반환한다.
2. `ordinal()` : 열거된 순서를 정수형으로 반환, 배열의 인덱스와 같이 `0`부터 시작된다.
   - 반환 값은 상수값과 연관이 없다. 단순한 열거 순서라고 생각하면 된다.
3. `valueOf(String name)` : 입력받은 문자열과 열거된 상수명을 비교해 같은 이름의 상수명을 반환한다.  
   - 만약 일치하는 상수명이 없다면 `IllegalArgumentException` 예외 발생

## Enum의 장점
- 문자열과 비교해 IDE(3)의 적극적인 지원(자동완성, 오타검증, 텍스트 리팩토링 등)을 받을 수 있다.
- 허용 가능한 값을 제한 가능하다.
- 리팩토링시 변경 범위가 최소화 된다. 즉, 내용 추가가 필요한 경우 Enum 코드만 수정하면 된다!

## 용어 정리
1. `열거` : 여러 가지 예나 사실을 낱낱이 죽 늘어놓음 - [Naver 국어사전](https://ko.dict.naver.com/#/entry/koko/105f900658854a62bb0a52ed3ac2773d)
2. `상수` : 변하지 않고 고정된 값을 저장함
3. `IDE(통합 개발 환경)` : 프로그래머가 소프트웨어 코드를 효율적으로 개발하도록 돕는 소프트웨어 애플리케이션

## 참조 URL
- [우아한 기술블로그](https://techblog.woowahan.com/2527/)