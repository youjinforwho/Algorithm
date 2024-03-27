def solution(k, tangerine):
    tan_score = []
    tangerine.sort()
    count = 0
    last_num = tangerine[-1]
    while tangerine:
        if last_num == tangerine[-1]:
            count += 1
        else:
            tan_score.append(count)
            count = 1
        last_num = tangerine[-1]
        tangerine.pop()
    if count != 0:
        tan_score.append(count)
    tan_score.sort()
    pick = 0 
    box = []
    while (k > pick):
        pick += tan_score[-1]
        tan_score.pop()
        box.append(0)
    answer = len(box)
    return answer