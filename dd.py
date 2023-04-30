def solution(dirs):
    answer = 0
    coordinate_sys = [[0] * 10 for _ in range(10)]
    x = y = 5
    flag = False
    for i in dirs:
        if i == 'R' and x < 10:
            x += 1
        elif i == 'L' and x > 0:
            x -= 1
        elif i == 'D' and y < 10:
            y += 1
        elif i == 'U' and y > 0:
            y -= 1
        if coordinate_sys[x][y] == 1:
            flag = True
        coordinate_sys[x][y] = 1
        print(x, y)
    coordinate_sys[5][5] = 1
    for i in range(10):
        for j in range(10):
            if coordinate_sys[i][j] == 1:
                answer += 1
    if flag == False:
        answer -= 1
    return answer
#(0, 0) (0, 10)
print(solution("ULURRDLLU"))