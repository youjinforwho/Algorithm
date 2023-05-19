n, k = map(int, input().split())
cable = []
pl = 1
res_max = pr = 0
for _ in range(n):
    x = int(input())
    cable.append(x)
    pr += x
pr //= k
while (pl <= pr):
    res = 0
    mid = (pl + pr) //2
    for i in cable:
        res += i // mid
    if res >= k:
        pl = mid + 1
        if mid > res_max:
            res_max = mid
    else:
        pr = mid - 1
print(res_max)