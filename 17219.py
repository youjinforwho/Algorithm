import sys
input = sys.stdin.readline
n, m = map(int, input().split())
notepad = {}
for _ in range(n):
    k, v = map(str, input().split())
    notepad[k] = v
for _ in range(m):
    find = input().rstrip()
    print(notepad[find])