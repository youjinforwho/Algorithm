import sys
input = sys.stdin.readline
n = int(input())
li = []
for _ in range(n):
    li.append(int(input()))
freq = dict()
for i in li:
    if freq.get(i, 0) == 0:
        freq[i] = 1
    else:
        freq[i] += 1
for num, cnt in freq.items():
    for _ in range(cnt):
        print(num)