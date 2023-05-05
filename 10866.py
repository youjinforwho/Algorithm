import sys
input = sys.stdin.readline
from collections import deque
def push_back(num):
    dq.append(num)
def push_front(num):
    dq.appendleft(num)
def pop_front():
    if dq:
        print(dq[0])
        dq.popleft()
    else:
        print(-1)
def pop_back():
    if dq:
        print(dq[-1])
        dq.pop()
    else:
        print(-1)

n = int(input())
dq = []
dq = deque(dq)
for i in range(n):
    order = list(map(str, input().split()))
    if len(order) == 2:
        if order[0] == "push_back":
            push_back(int(order[1]))
        elif order[0] == "push_front":
            push_front(int(order[1]))
    else:
        if order[0] == "pop_front":
            pop_front()
        elif order[0] == "pop_back":
            pop_back()
        elif order[0] == "front":
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
        else:
            if dq:
                print(0)
            else:
                print(1)
    