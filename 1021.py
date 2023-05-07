import sys
input = sys.stdin.readline
from collections import deque
n, m = map(int, input().split())
dq = list(range(1, n + 1))
dq = deque(dq)
res = 0
find = list(map(int, input().split()))
for i in range(len(find)):
    cnt = 0
    while (find[i] != dq[cnt]):
        cnt += 1
    if cnt * 2 <= len(dq):
        while (dq[0] != find[i]):
            dq.append(dq.popleft())
            res += 1
        dq.popleft()
    else:
        while (dq[0] != find[i]):
            dq.appendleft(dq.pop())
            res += 1
        dq.popleft()
print(res)