import sys
for _ in range(int(sys.stdin.readline().rstrip())) :
    x1,y1,r1, x2,y2,r2 = map(int,sys.stdin.readline().split())
    d = (abs(x1-x2)**2 + abs(y1-y2)**2)**.5
    if d == 0 and r1==r2 : print(-1)
    elif r1+r2 < d or d < abs(r1-r2) : print(0)
    elif r1+r2 == d or d == abs(r1-r2) : print(1)
    elif abs(r1-r2) < d and d < r1+r2 : print(2)