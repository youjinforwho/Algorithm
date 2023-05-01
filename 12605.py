n = int(input())
for i in range(n):
    case = list(map(str, input().split()))
    case = ' '.join(case[::-1])
    print("Case #%d: %s" %(i + 1, case))