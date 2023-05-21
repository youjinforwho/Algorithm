import sys
from collections import Counter
input = sys.stdin.readline
n = int(input())
li = []
for _ in range(n):
    li.append(int(input()))
mean = int(sum(li))
if mean >= 0:
    print(int(sum(li) / n + 0.5))
elif mean < 0:
    print(int(sum(li) / n - 0.5))
li.sort()
print(li[len(li) // 2]) #중앙값 출력
cnt = Counter(li).most_common()
if len(cnt) != 1 and cnt[0][1] == cnt[1][1]:
    print(cnt[1][0])
else:
    print(cnt[0][0])
print(abs(li[-1] - li[0])) #범위 출력