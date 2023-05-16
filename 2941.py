import sys
input = sys.stdin.readline
croatia = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
s = input()
ptr = 0
cnt = 0
while (ptr != len(s) - 1):
    if ptr <= len(s) - 3 and s[ptr : ptr + 3] in croatia:
        ptr += 3
    elif ptr <= len(s) - 2 and s[ptr : ptr + 2] in croatia:
        ptr += 2
    else:
        ptr += 1
    cnt += 1
print(cnt)