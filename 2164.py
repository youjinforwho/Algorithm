from collections import deque
card = int(input())
dq = list(range(1, card + 1))
dq = deque(dq)
while (len(dq) != 1):
    dq.popleft()
    dq.append(dq.popleft())
print(dq[0])