from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
dq = []
dq = deque(dq)
for i in range(n):
    order = list(map(str, input().split()))
    if len(order) == 1:
        if order[0] == "front":
            if dq:
                print(dq[0])
            else:
                print(-1)
        elif order[0] == "back":
            if dq:
                print(dq[-1])
            else:
                print(-1)
        elif order[0] == "size":
            print(len(dq))
        elif order[0] == "empty":
            if dq:
                print(0)
            else:
                print(1)
        elif order[0] == "pop":
            if dq:
                print(dq.popleft())
            else:
                print(-1)
    else:
        dq.append(order[1])