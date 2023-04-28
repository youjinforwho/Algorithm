fibo= [1,2]
while fibo[-1] < 1000000001:
    fibo.append(fibo[-1] + fibo[-2])
N = int(input())
for i in range(N):
    a = int(input())
    res = []
    for j in range(len(fibo) - 1, -1, -1):
        if fibo[j] <= a:
            a -= fibo[j]
            res.append(fibo[j])
    res.reverse()
    for j in res:
       print(j, end=" ")
    if i != N - 1:
        print()