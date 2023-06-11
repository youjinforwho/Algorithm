#case1: 100에서 무지성 이동
#case2: 밑 채널 이동-> 올리기
#case3: 위 채널 이동-> 내리기
#셋 중 적은 횟수 출력
def check(num): #int 형으로 들어온 값들을 쪼개고, 이 중 고장난 버튼에 해당되는게 있으면 0 반환, 그렇지 않으면 1 반환
    while (num >= 10):
        if num % 10 in broke:
            return 0
        num //= 10
    if num in broke:
        return 0
    return 1

def digit(num):
    digit_num = 1
    while (num >= 10):
        num //= 10
        digit_num += 1
    return (digit_num)
import sys
n = int(input())
m = int(input())
if m == 0:
    if abs(n - 100) < digit(n):
        print(abs(n - 100))
    else:
        print(digit(n))
    sys.exit()
broke = list(map(int, input().split()))
temp = n
case_1, case_2 = 0, 0
while (check(temp) == 0):
    temp -= 1
if temp < 0:
    case_1 = abs(n - 100)
else:
    case_1 = n - temp + digit(temp)
temp = n
while (check(temp) == 0):
    if sum(broke) == 45:
        break
    temp += 1
if sum(broke) == 45:
    case_2 = case_1
else:
    case_2 = temp - n + digit(temp)
if case_2 < case_1:
    case_1 = case_2
if abs(n - 100) < case_1:
    case_1 = abs(n - 100)
print(case_1)
