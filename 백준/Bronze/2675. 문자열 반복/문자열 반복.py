import sys
T= int(sys.stdin.readline().rstrip())
for i in range(T) :
    r,s = map(str,sys.stdin.readline().split())
    for i in s :
        print(i*int(r), end="")
    else : print('')