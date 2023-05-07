from collections import deque
Q = list(range(1, int(input()) + 1))
Q = deque(Q)
res = []
while len(Q) != 1:
    res.append(Q.popleft())
    Q.append(Q.popleft())
res.append(Q.popleft())
print(' '.join(map(str, res)))
