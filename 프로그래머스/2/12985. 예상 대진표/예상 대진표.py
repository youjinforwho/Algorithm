def solution(n,a,b):
    turn = 1
    round = 2
    x = a - 1
    y = b - 1
    while (round <= n):
        if x // round == y // round:
            break
        turn += 1
        round *= 2
    answer = turn
    return answer

