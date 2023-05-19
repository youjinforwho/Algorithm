x,y,w,h=map(int,input().split())

if x>w-x:
    x_min=w-x
else:
    x_min=x
if y>h-y:
    y_min=h-y
else:
    y_min=y
    
if x_min<y_min:
    print(x_min)
else:
    print(y_min)