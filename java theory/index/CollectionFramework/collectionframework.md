# Collection Framework ?
- 다수의 데이터를 보다 쉽고 효과적으로 처리할 수 있는 표준화된 방법을 제공하는 클래스 집합
- 즉, 자료구조와 데이터 처리 알고리즘을 구조화해 클래스로 구현한 것
- 자바의 인터페이스(interface)를 사용해 구현됨

## 간단한 용어 정리
- `Collection(컬렉션)` - 다수의 객체(데이터) 집합, `JAVA API 문서`에서는 다수의 데이터 군으로 표현
- `Collection class(컬렉션 클래스)` - 다수의 객체를 저장할 수 있는 클래스
   - `Collection Framework`의 인터페이스를 구현한 클래스를 뜻함

## 라이브러리와 프레임웍은 다른가?
- `라이브러리` - 공통적으로 사용될 만한 기능을 제공, 표준화 X
- `프레임웍` - 기능 제공만이 아니라 표준화된 프로그래밍 방식 제공, 표준화 O

## 주요 인터페이스 요약
1. `Collection 인터페이스`
   - List 인터페이스와 Set 인터페이스의 `공통된 부분`을 모아 정의한 인터페이스
   - List 인터페이스와 Set 인터페이스는 해당 인터페이스를 상속한다
2. `List 인터페이스`
   - 순서가 있는 데이터의 집합, 데이터의 중복을 허용한다
   - 구현클래스에는 `ArrayList`, `LinkedList`, `Stack`, `Vector` 등이 있다
3. `Set 인터페이스`
   - 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않는다
   - 구현클래스에는 `HashSet`, `TreeSet` 등이 있다
4. `Map 인터페이스`
   - `키(key)`와 `값(value)`의 쌍(pair)으로 이루어진 데이터 집합
   - 순서를 유지하지 않으며, `키(key)`는 중복을 허용하지 않고 `값(value)`은 중복을 허용한다
   - 구현클래스에는 `HashMap`, `TreeMap`, `HashTable`, `Properties` 등이 있다
- 각 인터페이스의 특징과 차이를 알아야 개발에 필요한 컬랙션 클래스를 결정할 수 있다

## Collection 인터페이스
- List 인터페이스와 Set 인터페이스의 `공통된 부분`을 모아 정의한 인터페이스, 기본적인 메서드들을 정의함
- 컬렉션 클래스에 저장된 데이터의 추가, 삭제, 검색 등의 기능을 하는 메서드들을 정의함
### Collection 인터페이스에 정의된 메서드
1. 추가 기능
   - `boolean add(Object o)` or `boolean addAll(Collection c)`
     - 지정한 객체(o) 또는 Collection(c)의 객체들을 Collection에 추가
2. 삭제 기능
   - `void clear()` - Collection의 모든 객체를 삭제
   - `boolean remove(Object o)` - 지정된 객체(o)를 삭제, 성공은 `true`를 실패는 `false`를 반환
   - `boolean removeAll(Collection c)` - 지정한 Collection에 포함된 객체들을 삭제
   - `boolean retainAll(Collection c)` - 지정한 Collection에 포함되지 않은 객체들을 삭제
    - 컬렉션에 변화가 있다면 `true` 변화가 없다면 `false`를 반환
3. 검색 기능
   - `boolean cotains(Object o)` or `boolean cotainsAll(Collection c)`
     - 지정한 객체(o) 또는 Collection(c)의 객체들이 Collection에 포함되어 있는지 확인
   - `int size()` - Collection에 저장된 객체의 개수를 반환
- 위의 메서드 외에도 `JDK 1.8`부터 추가된 `람다(Lambda)`와 `스트림(Stream)`에 관한 메서드들도 있다
- 해당 메서드들은 차후에 따로 정리해보도록 함

## List 인터페이스
- `데이터의 중복을 허용`하면서 `저장순서를 유지`하는 컬렉션 클래스를 구현하는데 사용됨
- 해당 인터페이스를 구현한 대표적인 컬렉션 클래스에는 `ArrayList`와 `LinkedList`가 있다
### List 인터페이스에 정의된 주요 메서드
- 당연하지만 상속받은 Collection 인터페이스의 메서드는 제외하였다
1. 읽기 기능
   - `Object get(int index)` - 저장된 위치(index) 객체를 반환
   - `List subList(int fromIndex, int toIndex)` - 지정된 범위의 객체를 반환
2. 추가 기능
   - `void add(int index, Object element)` or `void add(int index, Collection c)`
     - 지정한 위치(index)에 객체(element) 또는 Collection에 포함된 객체들을 추가
3. 삭제 기능
   - `Object remove(int index)` - 지정된 위치(index)에 있는 객체를 삭제하고 해당 객체를 반환
4. 검색 기능
   - `int indexOf(Object o)` - 지정된 객체의 위치(index)를 반환한다, 순방향 검색
   - `int lastIndexOf(Object o)` - 지정된 객체의 위치(index)를 반환한다, 역방향 검색
5. 수정 기능
   - `Object set(int index, Object element)` - 지정된 위치(index)에 객체(element)를 저장
6. 정렬 기능
   - `void sort(Comparator c)` - 지정된 `Comparator(1)`를 통해 List를 정렬

## Set 인터페이스
- `데이터의 중복을 허용하지 않고` `저장순서가 유지되지 않는` 컬렉션 클래스를 구현하는데 사용됨
- 해당 인터페이스를 구현한 대표적인 컬렉션 클래스에는 `HashSet`과 `TreeSet`이 있다
### Set 인터페이스에 정의된 주요 메서드
- 모두 Collection 인터페이스에 상속받아 사용해 Collection 인터페이스의 주요 메서드와 같다

## Map 인터페이스
- `키(key)`와 `값(value)`을 하나의 쌍으로 묶어 저장하는 컬렉션 클래스를 구현하는데 사용됨
- 해당 인터페이스를 구현한 대표적인 컬렉션 클래스에는 `HashMap`과 `TreeMap`이 있다
### Map 인터페이스에 정의된 주요 메서드
1. 읽기 기능
    - `Set entrySet()` - Map에 저장된 key-value 쌍을 Map.Entry 타입의 객체로 저장한 Set을 반환
    - `Set keySet()` - Map에 저장된 모든 key 객체를 반환
    - `Collection values()` - Map에 저장된 모든 value 객체를 반환
2. 추가 기능
    - `Object put(Object key, Object value)` - Map의 value 객체를 key 객체에 연결(mapping)하여 저장
    - `void putAll(Map t)` - 지정된 Map의 모든 key-value 쌍을 추가
3. 삭제 기능
    - `Object remove(Object key)` - 지정된 key 객체와 일치하는 key-value 객체를 삭제
4. 검색 기능
    - `boolean containsKey(Object key)` - 지정된 key 객체와 일치하는 Map의 key 객체가 있는지 확인
    - `boolaen containsValue(Object Value)` - 지정된 value 객체와 일치하는 Map의 value 객체가 있는지 확인
    - `Object get(Object key)` - 지정된 key 객체에 대응하는 value 객체를 찾아 반환
- 중복이 허용되는 `값(value)`의 경우 Collection 타입으로 반환한다
- 중복이 허용되지 않는 `키(key)`의 경우 Set 타입으로 반환한다

## Collection class
- 해당 내용까지 적기엔 내용이 너무 많아 이 부분은 따로 `Collection class` 별로 정리하도록 하겠다
- 추후 `java theory/index/<Collection class 이름>` 경로에 업데이트 하도록 하겠다

## 용어 정리
1. `Comparator` : 인터페이스로 기본 정렬 기준과 다르게 정렬하고 싶을 때 사용한다
   - `Comparable` : 인터페이스로 기본 정렬 기준을 다루는 메서드를 정의함
     - Ex) `Integer` - 오름차순 정렬, `String` - 사전순 정렬