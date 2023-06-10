def can_div(a):
    global n_2, n_5
    if a % 2 == 0:
        n_2 += 1
        can_div(a // 2)
    elif a % 5 == 0:
        n_5 += 1
        can_div(a // 5)

import sys
input = sys.stdin.readline
cnt = 0
n_2, n_5 = 0, 0
n = int(input())
for i in range(1, n + 1):
    can_div(i)
if n_2 >= n_5:
    print(n_5)
else:
    print(n_2)
