import sys
input = sys.stdin.readline
n = int(input())
<<<<<<< HEAD
<<<<<<< HEAD
li = [0] * 10001
for _ in range(n):
    a = int(input())
    li[a] += 1
for i in range(10001):
    if li[i] != 0:
        for _ in range(li[i]):
            print(i)
=======
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
>>>>>>> a6a5d27 (TIL 20230521)
=======
li = [0] * 10001
for _ in range(n):
    a = int(input())
    li[a] += 1
for i in range(10001):
    if li[i] != 0:
        for _ in range(li[i]):
            print(i)
>>>>>>> edc0241 (TIL 20230521)
