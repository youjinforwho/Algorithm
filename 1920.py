n = int(input())
a = list(map(int, input().split()))
a.sort()
m = int(input())
b = list(map(int, input().split()))
for i in b:
    pl = 0
    pr = n - 1
    mid = (pl + pr) // 2
    while pl <= pr:
        if a[mid] == i:
            print(1)
            break
        elif a[mid] > i:
            pr = mid - 1
        else:
            pl = mid + 1
        mid = (pl + pr) //2
    if pl > pr:
        print(0)
