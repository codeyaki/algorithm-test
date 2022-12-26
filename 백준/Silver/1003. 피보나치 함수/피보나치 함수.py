import sys

n = int(sys.stdin.readline().rstrip())
cntFibo = [[1,0], [0,1]]
cntFibo += [[0,0]] *39
for i in range(41):
    if cntFibo[i] != [0,0]: continue
    cntFibo[i] = [x+y for x,y in zip(cntFibo[i-1], cntFibo[i-2])]

num = []
for i in range(n):
    num = int(sys.stdin.readline().rstrip())
    print(*cntFibo[num])