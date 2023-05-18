n, m = map(int, input().split())
tree = list(map(int, input().split()))
pl = 1
pr = max(tree)
max_res = 0
while (pl <= pr):
    mid = (pl + pr) // 2
    res = 0
    for i in tree:
        if i > mid:
            res += i - mid
    if res == m:
        max_res = mid
        break
    elif res > m:
        max_res = mid
        pl = mid + 1
    else:
        pr = mid - 1
print(max_res)

