n, m, b = map(int, input().split())
li = []
mean = res = 0
for i in range(n):
    arb = list(map(int, input().split()))
    for j in range(m):
        li.append(arb[j])
        mean += arb[j]
if (mean / (m * n) - mean // (m * n)) >= 0.5:
    mean = int(mean / (m * n) + 0.5)
else:
    mean = mean // (m * n)
for i in range(n * m):
    if li[i] > mean:
        res += (li[i] - mean) * 2
    elif li[i] < mean:
        res += (mean - li[i])
print(res, mean)