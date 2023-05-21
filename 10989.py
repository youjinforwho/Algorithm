import sys
input = sys.stdin.readline
n = int(input())
li = [0] * 10001
for _ in range(n):
    a = int(input())
    li[a] += 1
for i in range(10001):
    if li[i] != 0:
        for _ in range(li[i]):
            print(i)