import sys
input = sys.stdin.readline
n, m = map(int,input().split())
li = {}
res = []
for _ in range(n):
    key = input()
    li[key] = 1
for _ in range(m):
    who = input()
    if li.get(who, 0) == 1:
        res.append(who)
res.sort()
print(len(res))
for i in res:
    print(i.rstrip('\n'))
