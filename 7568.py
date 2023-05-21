n = int(input())
count = 0
player = []
for i in range(n):
    height, weight = map(int, input().split())
    player.append((height, weight))
for i in range(n):
    grade = 1
    for j in range(n):
        if i == j:
            pass
        elif player[i][0] < player[j][0] and player[i][1] < player[j][1]:
            grade += 1
    print(grade)