/*
  그냥 자려다가 알고리즘 문제를 꼬박 꼬박 푸는 습관을 들이기 위해
  비교적 쉬운 문제라도 풀고 자기 위해 이 문제를 골랐다.
  재귀로 피보나치(fibo메소드라고 치면)를 구현할 경우 같은 값을 계속 해서 반복호출하는데
  이때 fibo(0)과 fibo(1)이 각각 몇번 호출되는지를 구하는 문제이다.  
  
  최근 파이썬 공부를 시작하여 한번 파이썬으로 풀어봤는데 내가 문법에 익숙치 않아 아직은 많이 헷갈리지만  
  확실히 파이썬이 알고리즘 문제 풀기에 더 편한것같단 느낌이 든다.  
  자바로도 다시 풀어봐야겠다.
*/

t = int(input())
n = [0 for _ in range(t)]

for i in range(t):
    n[i] = int(input())+1
    #print(n[i])

for i in range(t):
    if n[i] == 1:
        print("1 0")
        continue

    fibo = [0 for _ in range(n[i])]
    fibo[0] = (1,0)
    fibo[1] = (0,1)
    for j in range(2,n[i]):
        fibo[j] = tuple(sum(elem) for elem in zip(fibo[j-1],fibo[j-2]))
        #print("fibo[",i,"]"," >> ", fibo[i])

    a = str(list(fibo[n[i]-1]))
    print(a[1:len(a)-1].replace(',','',1))
