T = int(input())
for _ in range(T):
    R, S = map(str, input().split())
    res = ""
    for i in S:
        res += i * int(R)
    print(res)