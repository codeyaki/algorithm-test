import sys
answer = set([int(sys.stdin.readline())%42 for i in range(10)])
print(len(answer))