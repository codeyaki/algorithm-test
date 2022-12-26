import sys
for line in sys.stdin :
    x,y,r = sorted(map(int,line.split()))
    if x==0 : break
    print("right" if x**2 + y**2 == r**2 else "wrong")