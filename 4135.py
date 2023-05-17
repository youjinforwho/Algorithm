while True:
    tri = list(map(int, input().split()))
    if tri[0] == tri[1] == tri[2] == 0:
        break
    tri.sort()
    if tri[0] + tri[1] < tri[2]:
        print("wrong")
    elif tri[0] * tri[0] + tri[1] * tri[1] == tri[2] * tri[2]:
        print("right")
    else:
        print("wrong")