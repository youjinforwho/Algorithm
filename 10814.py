n = int(input())
mem = [[0]*2 for _ in range(n)]
for i in range(n):
    x, y = map(str, input().split())
    mem[i][0] = int(x)
    mem[i][1] = y
mem.sort(key = lambda x : x[0])
for i in mem:
    print(i[0], i[1])