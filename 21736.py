def DFS(x, y):
    global per
    if x + 1 < n and campus[x + 1][y] !='X':
        if campus[x + 1][y] == 'P':
            per += 1
        campus[x + 1][y] = 'X'
        DFS(x + 1, y)
    if x - 1 > -1 and campus[x - 1][y] != 'X':
        if campus[x - 1][y] == 'P':
            per += 1
        campus[x - 1][y] = 'X'
        DFS(x - 1, y)
    if y + 1 < m and campus[x][y + 1] !='X':
        if campus[x][y + 1] == 'P':
            per += 1
        campus[x][y + 1] = 'X'
        DFS(x, y + 1)
    if y - 1 > -1 and campus[x][y - 1] != 'X':
        if campus[x][y - 1] == 'P':
            per += 1
        campus[x][y - 1] = 'X'
        DFS(x, y - 1)
import sys
sys.setrecursionlimit(10**6)
n, m = map(int, input().split())
campus = [[0] * m for _ in range(n)]
per = 0
for i in range(n):
    string = input()
    for j in range(m):
        if string[j] == 'I':
            d_x, d_y = i, j
        campus[i][j] = string[j]
DFS(d_x, d_y)
if per == 0:
    print("TT")
else:
    print(per)