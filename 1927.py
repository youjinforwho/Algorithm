import heapq as hq
import sys
input = sys.stdin.readline
a = []
n = int(input())
for i in range(n):
    x = int(input())
    if x == 0:
        if len(a) == 0:
            print(0)
        else:
            print(hq.heappop(a))
    else:
        hq.heappush(a, x)