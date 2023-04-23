n, m = map(int, input().split())
a = [list(map(input().split())) for _ in range(n)]
b = list(map(int, input().split()))
for i in b:
    pl = 0
    pr = n - 1
    while (pl <= pr):
        mid = (pl + pr) // 2
        if int(a[1][mid]) == i:
            print(a[0][mid])
            break
        elif int(a[1][mid]) < i:
            pl = mid + 1
        else:
            pr = mid - 1
    if (pl > pr):
        print(a[0][mid])

