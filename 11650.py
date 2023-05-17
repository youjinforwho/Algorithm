n = int(input())
plain = [[0] * 2 for _ in range(n)]
for i in range(n):
    x, y = map(int, input().split())
    plain[i][0] = x
    plain[i][1] = y
plain.sort(key = lambda x : (x[0], x[1]))
for i in plain:
    print(i[0], i[1])