import sys
input = sys.stdin.readline
n, m = map(int,input().split())
li = []
res = []
for _ in range(n):
    li.append(input())
for _ in range(m):
    who = input()
    if who in li:
        res.append(who)
res.sort()
print(len(res))
for i in res:
    print(i.rstrip('\n'))
