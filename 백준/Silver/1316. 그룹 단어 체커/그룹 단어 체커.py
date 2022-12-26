import sys
n = int(sys.stdin.readline().rstrip())
answer = 0
for _ in range(n) :
    s = sys.stdin.readline().rstrip()
    for i in s :
        s= s.replace(i*2,i,1)
    else :
        setS = set(s)
        if len(setS) == len(s) : answer += 1

print(answer)
