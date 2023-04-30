N = int(input())
link = list(map(int, input().split()))
node = list(map(int, input().split()))
pl = pr = 0
fee = 0
while (pr < N - 1):
    distance = 0
    while pr < N - 1 and node[pl] <= node[pr]:
        distance += link[pr]
        pr += 1
    fee += node[pl] * distance
    pl = pr
print(fee)