## 개선할만한 부분

### 문제 - N이 주어졌을 때 피보나치 수를 1234567로 나눈 나머지를 리턴

+ 단순 1234567로 나누는 것이 아니다. 100000과 같은 수의 피보나치 수는 엄청난 크기 이기 때문에 int로 리턴 할 수 있도록 문제를 낸 것!
+ (A + B) % C ≡ ( ( A % C ) + ( B % C) ) % C 라는 엄청난 수학 공식을 사용하자
+ 피보나치 수를 구하는 방법은 크게 재귀함수, 배열, 재귀함수 + 배열 사용하기

### 1. 재귀함수
+ f(n) = f(n-1) + f(n-2) 공식 사용하기
+ 이 경우 f(5) = f(4) + f(3) = f(3) + f(2) + f(2) + f(1) = ... 와 같은 결과로 구성된다
+ 수가 많으면 당연히 스택오버플로우가 발생할 수 밖에 없는 구조!!
```java
public int fibonacci(int n) {
    if(n <= 1) {
        return n;
    }

    return fibonacci(n-1) + fibonacci(n-2);
}

```

### 2. 배열을 사용해보자
+ f(5) = f(4) + f(3) 이라는 것은 결국 f(4)와 f(3)을 더하면 된다는 의미
+ 각각의 값을 구해서 배열에 저장해두고 쓰는 방식
```java
int[] arr = new int[100];

arr[1] = 1; 
arr[2] = 1; 

for (int i = 3; i < 100; i++) { 
    arr[i] = arr[i - 1] + arr[i - 2]; 
}
```

### 2-1. 배열 없이도 가능하다!
```java
int prevPrevNum = 1; // 전 전 항 (n-2) 
int prevNum = 1; // 이전 항 (n-1) 

for (int i = 3; i < 100; i++) { 
    int curNum = prevPrevNum + prevNum; // 현재 항 (n)
    prevPrevNum = prevNum; 
    prevNum = curNum; 
}
```

### 3. 재귀함수 + 배열
+ 재귀함수에서 중복되는 부분을 배열로 처리하는 방법
```java
int[] memo = new int[100];

int fibonacci(int k) { 
    if (memo[k] != 0) { // 이미 계산한 값 
    } else { // 처음 계산되는 값 
        if (k <= 2) { 
            memo[k] = 1; 
        } else { // 3번째 항 부터는 계산 
            memo[k] = fibo(k - 1) + fibo(k - 2); 
        } 
    } return memo[k]; 
}
```

+ 출처 : 출처: https://memostack.tistory.com/92