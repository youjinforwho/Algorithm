n = int(input())
plane = [[0] * 2 for _ in range(n)]
for i in range(n):
    x, y = map(int, input().split())
    plane[i] = (x, y)
plane.sort(key = lambda x : (x[1], x[0]))
for i in plane:
    print(i[0], i[1])