import sys
for _ in range(int(sys.stdin.readline().rstrip())) :
    h,w,n = map(int, sys.stdin.readline().split())
    print(int(f"{((n-1)%h)+1}{(((n-1)//h)+1):02}"))