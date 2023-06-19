def DFS(v, pick):
    if v > n or (v == n and pick != m):
        return
    if pick == m:
        print(*chk)
        print()
    else:
        for i in range(m):

n, m = map(int, input().split())
chk = []
DFS(0, 0)
