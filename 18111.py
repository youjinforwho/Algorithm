import sys
input = sys.stdin.readline
n, m, b = map(int, input().split())
li = []
for i in range(n):
    arb = list(map(int, input().split()))
    for j in range(m):
        li.append(arb[j])
li.sort(reverse = True)
min = int(2e9)
for i in range(0, max(li) + 1):
    flag = True
    resource = b
    spend = 0
    for j in li:
        if j > i:
            spend += 2 * (j - i)
            resource += j - i
        elif j < i:
            if resource >= i - j:
                resource -= i - j
                spend += i - j
            else:
                flag = False
                break
    if flag == True:
        if min >= spend:
            answer = [spend, i]
            min = spend
print(*answer)