n = input()
sum = num = 0
max = 0
for i in n:
    if (i == '+'):
        sum += num
        num = 0
    elif (i == '-'):
        sum += num
        num = 0
        if (sum > max):
            max = sum
            sum = 0
            print(max)
    else:
        num = num * 10 + int(i)