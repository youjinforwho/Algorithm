import sys
input = sys.stdin.readline
S = input().rstrip()
T = input().rstrip()
ptr = -1
while (len(S) < len(T)):
    if ptr < 0:
        check = -1
    else:
        check = 0
    if T[check] == 'A':
        if ptr > 0:
            T = T[1 :]
        else:
            T = T[: -1]
    elif T[check] == 'B':
        if ptr > 0:
            T = T[1 :]
        else:
            T = T[: -1]
        ptr *= -1
if ptr > 0:
    T = "".join(reversed(T))
if S == T:
    print(1)
else:
    print(0)

