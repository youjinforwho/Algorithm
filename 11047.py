N, K = map(int, input().split())
res = []
cnt = 0
for i in range(N):
    coin = int(input())
    res.append(coin)
while K != 0:
    if (K >= res[-1]):
        cnt += (K // res[-1])
        K = K % res[-1]
    else:
        res.pop()
print(cnt)