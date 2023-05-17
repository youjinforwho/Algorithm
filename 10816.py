import sys
input = sys.stdin.readline
m = int(input())
sanguen = list(map(int, input().split()))
card = {}
n = int(input())
li = list(map(int, input().split()))
for i in li:
    card[i] = 0
for i in sanguen:
    if card.get(i, -1) >= 0:
        card[i] += 1
for i in range(n):
    print(card[li[i]], end = ' ')