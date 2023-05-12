import sys
from collections import deque
input = sys.stdin.readline
do = [1, 2, 3]
su = [1, 2, 3]
ground = []
play = 0
do = deque(do)
su = deque(su)
do.append(su)
print(do)
n, m = map(int, input().split())
for i in range(n):
    a, b = map(int, input().split())
    do.append(a)
    su.append(b)
while do and su and play <= m:
    