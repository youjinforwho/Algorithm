import sys
input = sys.stdin.readline
n = int(input())
dict = {}
sanguen = list(map(int, input().split()))
for i in sanguen:
    dict[i] = 1
m = int(input())
field = list(map(int, input().split()))
for i in field:
    if dict.get(i, 0) == 1:
        print('1', end = ' ')
    else:
        print('0', end = ' ')