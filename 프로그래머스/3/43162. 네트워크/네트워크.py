def dfs(x, computers):
    idx = 0
    for i in computers[x]:
        if idx != x and i == 1:
            computers[x][idx] = 0
            computers[idx][x] = 0
            dfs(idx, computers)
        idx += 1
    return

def solution(n, computers):
    answer = 0
    for i in computers:
        if sum(i) == 1:
            answer += 1
    for i in range(n):
        for j in range(n):
            if i != j and computers[i][j] == 1:
                computers[i][j] = 0
                computers[j][i] = 0
                dfs(j, computers)
                answer += 1
    return answer