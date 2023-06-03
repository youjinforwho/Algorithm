import sys
input = sys.stdin.readline
n, m, b = map(int, input().split())
li = []
for i in range(n):
    arb = list(map(int, input().split()))
    for j in range(m):
        li.append(arb[j])
pl = 0
pr = max(li)
li.sort(reverse = True)
min = int(2e9)
while (pl <= pr):
    flag = True
    resource = b
    spend = 0
    mid = (pl + pr) // 2
    for i in li:
        if i > mid:
            spend += 2 * (i - mid)
            resource += i - mid
        elif i < mid:
            if resource >= mid - i:
                resource -= mid - i
                spend += mid - i
            else:
                flag = False
                break
    if flag == True:
        if min >= spend:
            answer = [spend, mid]
            min = spend
    else:
        pr = mid - 1
    print(mid)
print(*answer)