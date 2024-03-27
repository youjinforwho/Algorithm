def solution(brown, yellow):
    answer = []
    num = brown + yellow
    yaksu = []
    for i in range(1, int(num ** (1/2)) + 1):
        if num % i == 0:
            yaksu.append(i)
            yaksu.append(num // i)
    for i in range(len(yaksu)//2):
        x = yaksu[i*2 + 1]
        y = yaksu[i*2]
        if (x - 2)*2 + y*2 == brown and (x - 2) * (y - 2) == yellow:
            answer.append(x)
            answer.append(y)
            break
    return answer