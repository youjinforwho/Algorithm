case = int(input())
student = list(map(str, input().split()))
mem = dict()
for i in student:
    mem[i] = 0
for i in range(case):
    n = list(map(str, input().split()))
    for i in n:
        mem[i] += 1
mem2 = sorted(mem.items(), key = lambda x : x[1], reverse = True)
for i in mem2:
    print(i[0], i[1])