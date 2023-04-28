N = int(input())
a = list(map(int, input().split()))
a.sort()
time = 0
for i in range(N):
    time += a[i] * (N - i)
print(time)
