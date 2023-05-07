from collections import deque
n, k = map(int, input().split())
q = list(range(1, n + 1))
q= deque(q)
li = []
cnt = 1
while q:
    while (cnt != k):
        cnt += 1
        q.append(q.popleft())
    li.append(q.popleft())
    cnt = 1
print('<' +', '.join(map(str, li)) + '>')