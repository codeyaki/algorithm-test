import sys
answer = 1
for i in range(3) : answer *= int(sys.stdin.readline().rstrip())
for i in range(10) : print(str(answer).count(str(i)))