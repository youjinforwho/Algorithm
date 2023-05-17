n, m = map(int, input().split())
card = list(map(int, input().split()))
res = []
for i in range(n):
    for j in range(i + 1, n):
        for k in range(j + 1, n):
            chk = card[i] + card[j] + card[k]
            if chk <= m:
                res.append(chk)
res.sort()
print(res[-1])